/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou
*/

public class BSTIndex {

    private class Node {
        private String key;
        private MovieInfo data;
        private Node left, right;

        public Node(MovieInfo info) {
            data = info;
            key = data.shortTitle;
        }
    }

    private Node root;

    public BSTIndex() {
        root = null;
    }

    // --------- [DO NOT MODIFY!] public BST methods  --------- //
    /* Important: Notice that each public method here calls another private method while passing it a reference to the tree root. This is a common way of structuring BST functions such that external client code will not have direct access to the tree root. You will be implementing the code in the private methods, not the public ones. */

    /* Calculate and return the height of the current tree. */
    public int calcHeight(){
        return calcNodeHeight(this.root);
    }

    /* Insert the given data element into the proper place in the BST structure. */
    public void insertMovie(MovieInfo data) {
        root = insertMovie(data, this.root);
    }

    /* Find and return the data element (i.e. the MovieInfo object)
    of the node where the movie's shortTitle matches the given key.
    Return null if the movie is not found. */
    public MovieInfo findMovie(String key) {
        return findMovie(this.root, key);
    }

    /* Print out all movies in the database whose shortTitle begins with
    the passed prefix string. If no movies match the given prefix, nothing
    will be printed. The order of printing does not matter, but make sure
    to print each match in a separate line. */
    public void printMoviesPrefix(String prefix) {
        printMoviesPrefix(this.root, prefix);
    }
    // ----------------- end of public methods ------------------ //


    private int calcNodeHeight(Node t) { // calculates the height of the given node
        if (t == null) // if the node is null then return 0
            return 0;

        int left = calcNodeHeight(t.left); // recursively calls calcNodeHeight to traverse down left
        int right = calcNodeHeight(t.right); // recursively calls calcNodeHeight to traverse down right

        if (left > right) { // add 1 to the value of the side that is greater in length and return that side
            return left + 1;
        } else {
            return right + 1;
        }

    }

    private Node insertMovie(MovieInfo data, Node t) { // inserts the given movie in the correct place on the tree
        if (t == null) { // return new node with MovieInfo data if current node is null
            return new Node(data);
        }

        if (t.data.shortTitle.equals(data.shortTitle)) { // if current node matches the node to be added then return current node
            return t;
        }

        else {
            if ((data.shortTitle.compareTo(t.data.shortTitle)) > 0) { // if data to add is larger than data in current node, recursively call insertMovie on right child node
                t.right = insertMovie(data, t.right);
            } else { // else recursively call insertMovie on left child node
                t.left = insertMovie(data, t.left);
            }

            return t; // return path to root
        }
    }

    private MovieInfo findMovie(Node t, String key) { // finds given movie and returns movieInfo for that movie
        if (t == null) { // if node is null return
            return null;
        }

        if (key.equals(t.data.shortTitle)) { // return movie info if node shortTitle matches key
            return t.data;
        } else { // else recursively call find movie depending on order comparison until reaches null or key found
            if ((key.compareTo(t.data.shortTitle)) > 1) {
                return findMovie(t.right, key);
            } else {
                return findMovie(t.left, key);
            }
        }
    }

    private void printMoviesPrefix(Node t, String prefix) { // returns all movies starting with given prefix
        if (t == null) { // if node is null stop and return
            return;
        }

        String prefixNoAst = prefix.substring(0, prefix.length()-1); // Chops off asterisk
        if (t.data.shortTitle.startsWith(prefixNoAst)) { // If node has shortTitle that begins with prefix, print full shortTitle
            System.out.println(t.data.shortTitle);
        }

        // recursive calls to printMoviesPrefix left and right
        printMoviesPrefix(t.left, prefix);
        printMoviesPrefix(t.right, prefix);
    }

}
