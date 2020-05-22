import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IndexTester {

    public static void main(String[] args)
    {

        if(args.length < 1)
        {
            System.out.println("Error: IMDB file name missing! Usage: java IndexTester data/fileNameHere.txt");
            return;
        }

        String fileName = args[0];
        int i = 0;
        long start = System.currentTimeMillis();
        BSTIndex bst = new BSTIndex();

        // Read the IMDB movies input file (e.g. "data/movies.txt" or "data/movies100K.txt")
        try{
            Scanner scan = new Scanner(new FileInputStream(fileName));
            while(scan.hasNext()){
                String line = scan.nextLine();
                String [] fields = line.split("\t");
                int id = Integer.parseInt(fields[0].trim());
                String shortTitle = fields[1].trim();
                String fullTitle = fields[2].trim();
                MovieInfo info = new MovieInfo(id, shortTitle, fullTitle);

                bst.insertMovie(info); // insert movie into BST
                i++;
                if(i % 10000 == 0){
                    System.out.println("Inserted " + i + " records.");
                }
            } // end of while loop
        } // end of try
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("\nFile " + fileName + " could not be read. Are you sure you saved it in the right directory?");
            System.exit(-1); // exit program
        } // end of catch

        long end = System.currentTimeMillis();
        System.out.println("Index building complete. Inserted " + i + " records. Elapsed time = " + (end - start)/1000 + " seconds.");

        Scanner input = new Scanner(System.in);
        System.out.println("\nWelcome to the IMDB movie search engine!");
        System.out.println("- Enter search string to find a specific movie. \n- Enter search string ending with '*' to print all movies that match this prefix. \n- Enter 'h' to print tree height. \n- Enter 'q' to quit.");

        System.out.print("Enter Option: ");
        while(input.hasNext()) {
            String search = input.nextLine().trim();

            if(search.equals("q")) break; // q = quit

            if(search.equals("h")){
                //compute and print the height of this tree
                System.out.println("Height of BSTIndex tree = " + bst.calcHeight());
            }
            else if(search.indexOf('*') > 0)
            {
                //call prefix search
                System.out.println("[Finding all movies that start with " + search.split("\\*")[0] + "..]");
                bst.printMoviesPrefix(search);
            }
            else
            {
                //call exact search to find a specific movie
                MovieInfo match = bst.findMovie(search);
                if(match == null)
                    System.out.println("Movie " + search + " Not Found");
                else
                    System.out.println(match.ID + " " + match.shortTitle + " " + match.fullTitle);
            }
            System.out.print("Enter Option: ");
        }
    }
}
