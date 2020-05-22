/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou*/

// Imports of necessary packages
import java.util.Stack;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

// This class is used to solve Mazes
public class MazeSolver {

    static char[][] maze;
    static int startX, startY;  // indices for starting the maze search
    static int endX, endY; // indices for ending the maze search

    // Constructor that creates the maze
    public MazeSolver(String fileName) throws IOException {
        startX = 0;
        startY = 0;
        readMaze(fileName); // initialize maze
    }

    // Helper method for reading the maze content from a file
    public static void readMaze(String filename) throws IOException {
        Scanner scanner;
        try{
            scanner = new Scanner(new FileInputStream(filename));
        }
        catch(IOException ex){
            System.err.println("[ERROR] Invalid filename: " + filename);
            return;
        }

        int N = scanner.nextInt();
        scanner.nextLine();
        maze = new char[N][N];
        endX = N-1; endY = N-1;
        int i = 0;
        while(i < N && scanner.hasNext()) {
            String line =  scanner.nextLine();
            String [] tokens = line.split("\\s+");
            int j = 0;
            for (; j< tokens.length; j++){
                maze[i][j] = tokens[j].charAt(0);
            }
            if(j != N){
                System.err.println("[ERROR] Invalid line: " + i + " has wrong # columns: " + j);
                return;
            }
            i++;
        }
        if(i != N){
            System.err.println("[ERROR] Invalid file: has wrong number of rows: " + i);
            return;
        }
    }

    // Helper method for printing the maze in a matrix format
    public void printMaze() {
        for (int i=0; i < maze.length; i++) {
            for (int j=0; j < maze.length; j++) {
                System.out.print(maze[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    // Public method to solve maze
    public void solveMaze() {
        Stack<MazePosition> path = new Stack<MazePosition>(); // Creates empty stack "path" that stores MazePosition objects
        MazePosition startPosition = new MazePosition(startX, startY); // Declares new MazePosition object "startPosition" and sets it to starting coordinates
        MazePosition endPosition = new MazePosition(endX, endY); // Declares new MazePosition object "endPosition" and sets it to end coordinates (dependent on maze)
        MazePosition position = startPosition; // Declares new MazePosition object "position" and sets it to starting coordinates (0,0)

        mark(position); // Changes start position to X
        path.push(position); // Pushes start position onto stack

        // While position is not the same as endPosition try to move
        while (position.getX() != endPosition.getX() || position.getY() != endPosition.getY()) {
                position = move(path, position); // Move position
                path.push(position);

                if (position == startPosition) { // If position made it all the way back to the start position then break out of loop (maze not solvable)
                    break;
                }
        }

        //Prints result (if position is endPosition then maze is solvable, otherwise maze is not)
        if (position.getX() == endPosition.getX() && position.getY() == endPosition.getY()) {
            System.out.println("Maze is SOLVABLE");
        } else {
            System.out.println("Maze is NOT solvable");
        }
    }

    // Private helper method to change char of current position to X
    private void mark(MazePosition positionToMark) {
        maze[positionToMark.getX()][positionToMark.getY()] = 'X';
    }

    // Private helper method to check surroundings for open path, move, and mark
    private MazePosition move(Stack path, MazePosition position){
        if (checkRight(position)) {
            position = new MazePosition(position.getX(), position.getY() + 1);
            mark(position);
        } else if (checkDown(position)) {
            position = new MazePosition(position.getX() + 1, position.getY());
            mark(position);
        } else if (checkLeft(position)) {
            position = new MazePosition(position.getX(), position.getY() - 1);
            mark(position);
        } else if (checkUp(position)) {
            position = new MazePosition(position.getX() - 1, position.getY());
            mark(position);
        } else {
            position = backtrack(path, position); // If no open path backtrack
        }
        return position;
    }

    // Private helper method for backtracking; pop top, set position to second down
    private MazePosition backtrack(Stack path, MazePosition position) {

        path.pop();
        position = (MazePosition) path.pop();
        return position;

    }

    // Private helper method to check for wall to right of current position
    private boolean checkRight(MazePosition position){ //Checks if there is a wall to the right
        if (position.getY() < maze[0].length - 1){
            if (maze[position.getX()][position.getY() + 1] == '0') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Private helper method to check for wall below the current position
    private boolean checkDown(MazePosition position){ //Checks if there is a wall below
        if (position.getX() < maze.length - 1){
            if (maze[position.getX() + 1][position.getY()] == '0') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Private helper method to check for wall to the left of the current position
    private boolean checkLeft(MazePosition position){ //Checks if there is a wall to the left
        if (position.getY() >  0){
            if (maze[position.getX()][position.getY() - 1] == '0') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    // Private helper method to check for wall above current position
    private boolean checkUp(MazePosition position) { //Checks if there is a wall above
        if (position.getX() >  0){
            if (maze[position.getX() - 1][position.getY()] == '0') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // main method to test mazeSolver
    public static void main(String[] args) throws IOException {
        // If no argument is provided, show error message
        if(args.length < 1) {
            System.err.println("[ERROR] Usage: java PathFinder maze_file");
            System.exit(-1);
        }
        // File name is provided properly as the first argument

       String fileName =  args[0];

        MazeSolver ms = new MazeSolver(fileName);
        System.out.println("[Before Traversal] Maze:");
        ms.printMaze();
        System.out.println();

        //Test solver
        ms.solveMaze();
        System.out.println();
        System.out.println("[After Traversal] Maze:");
        ms.printMaze();

    }

}
