/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou
*/

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Sorting {

    //-------------------------------------------------------------
    //---------- Below is an implementation of Bubble Sort --------
    //-------------------------------------------------------------
    public static void BubbleSort(long[] a) {
        int out, in;
        for(out = a.length-1; out > 0; out--) {
            boolean swapped = false;
            for(in = 0; in < out; in++) {
                if(a[in] > a[in+1]) {
                    exch(a, in, in+1);
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    //------------------------------------------------------------------
    //---------- Below is an implementation of Insertion Sort ----------
    //------------------------------------------------------------------
    public static void InsertionSort(long[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                exch(a, j, j-1);
            }
        }
    }

    //------------------------------------------------------------
    //------ Below is an implementation of Selection Sort --------
    //------------------------------------------------------------
    public static void SelectionSort(long[] a) {
        for (int current = 0; current < a.length; current++) { // Runs through array from beginning
            int smallest = current; // Index of the smallest item to the left of current
            boolean swap = false; // Boolean indicating the necessity of a swap
            for (int searchIndex = current; searchIndex < a.length; searchIndex++){ // Runs through array from current index
                if (a[searchIndex] < a[smallest]) { // If an item is smaller than the currently labeled smallest item
                    smallest = searchIndex; // then set smallest index to index of newly found smallest item
                    swap = true; // indicate a need for a swap
                }
            }
            if (swap) { // If there was an indicated need for a swap
                exch(a, current, smallest); // then swap the item in the current position with the found smallest item
            }
        }
    }

    //-----------------------------------------------------------------------
    //---------- Below is an implementation of recursive MergeSort ----------
    //-----------------------------------------------------------------------
    public static void MergeSort(long[] a) {
        long[] aux = new long[a.length];
        sort(a, aux, 0, a.length-1);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(long[] a, long[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(long[] a, long[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (aux[j] < aux[i]) 	a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }

    //-------------------------------------------------------------
    //---------- Below is an implementation of Quicksort ----------
    //-------------------------------------------------------------
    public static void QuickSort(long[] a) {
        QuickSort(a, 0, a.length-1);
    }

    private static void QuickSort(long[] a, int left, int right) {
        if(right - left <= 0)
            return;
        int pIdx = partition(a, left, right, right);	// always uses the right end element as pivot
        QuickSort(a, left, pIdx-1);
        QuickSort(a, pIdx+1, right);
    }

    private static int partition(long[] a, int left, int right, int pIdx) {
        long pivot = a[pIdx];
        exch(a, pIdx, right);
        int storeIndex = left;
        for(int i=left; i<right; i++) {
            if(a[i] <= pivot)
                exch(a, i, storeIndex++);
        }
        exch(a, right, storeIndex);
        return storeIndex;
    }

    //-----------------------------------------------------------------------
    //---------- Below is an implementation of Optimized QuickSort ----------
    //-----------------------------------------------------------------------
    public static void QuickSortOptimized(long[] a) {
        QuickSortOptimized(a, 0, a.length - 1);
    }

    private static void QuickSortOptimized(long[] a, int left, int right) { // QuickSort that randomizes array beforehand
        // and switches to insertion sort if number of elements to be sorted is less than 10

        if (right - left <= 0) // returns if right end passes left end
            return;

        if ((right - left) <= 10) { // Switches to InsertionSortForQSO if the number of elements to be sorted is less than 10
            InsertionSortForQSO(a, left, right);
        } else { // Otherwise randomizes elements, sets a pivot through the partition method, and recursively calls QSO for partitioned sections
            shuffle(a, left, right);
            int pIdx = partition(a, left, right, right);
            QuickSortOptimized(a, left, pIdx - 1);
            QuickSortOptimized(a, pIdx + 1, right);
        }
    }

    private static void shuffle(long[] a, int left, int right) { // Shuffles section of array from left index to right index
        Random rand = new Random();
        for (int i = left; i <= right; i++) { // exch each element starting from the beginning with an element at a randomly generated index
            int randomSwapIndex = rand.nextInt((right - left) + 1);
            exch(a, i, left + randomSwapIndex);
        }
    }
    private static void InsertionSortForQSO (long[] a, int left, int right) { // Sorts section of array from left index to right index by insertion sort
        for (int i = left; i <= right; i ++) {
            for (int j = i; j > left && a[j] < a[j-1]; j--) {
                exch(a, j, j-1);
            }
        }
    }

    //---------------------------------------------------------------------------
    //--------- Below is an implementation of non-recursive MergeSort -----------
    //---------------------------------------------------------------------------
    public static void MergeSortNonRec(long[] a) { // Merge sort using non-recursive algorithm
        long[] aux = new long[a.length];
        for (int counter = 1; counter <= a.length/2; counter = counter*2){ // counter represents the size of the "partitioned" section
            for (int i = 0; i < a.length; i = i + 2*counter) { // runs through array for every counter size
                int lo = i;
                int mid = i + (counter - 1);
                int hi = i + (2*counter - 1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }

    //---------------------------------------------------------------------
    // TODO: Apply MergeSort to the Linked List (see A4 handout for details)
    //---------------------------------------------------------------------
    public static void MergeSortLL(MyLinkedList list) {
        // Uncomment below when you implement mergeSort() in class MyLinkedList
        list.mergeSort();
    }

    //------------------------------------------------------
    //---------- Below are several helper methods ----------
    //------------------------------------------------------
    // This tests whether your sorted result is correct by comparing it to reference result
    public static boolean testSort(long[] a) {
        long[] a2 = new long[a.length];
        System.arraycopy(a, 0, a2, 0, a.length);
        Arrays.sort(a);
        for(int i = 0; i < a.length; i++)
            if(a2[i] != a[i])
                return false;
        return true;
    }

    // This creates an array with n randomly generated elements between (0, n*10]
    private static long[] randArray(int n) {
        long[] rand = new long[n];
        for(int i=0; i<n; i++)
            rand[i] = (int) (Math.random() * n * 10);
        return rand;
    }

    // This creates an ordered array with n elements in ascending order
    private static long[] orderedArray(int n) {
        long[] arr = new long[n];
        for(int i=0; i<n; i++)
            arr[i] = i+1;
        return arr;
    }

    // This method copies the elements from an array to a linked list
    private static void copyArrayToLinkedList(long[] arr, MyLinkedList list) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            list.addLast(arr[i]);
        }
    }

    private static void startTimer() {
        timestamp = System.nanoTime();
    }

    private static double endTimer() {
        return (System.nanoTime() - timestamp)/1000000.0;
    }

    // Exchange a[i] and a[j]
    private static void exch(long[] a, int i, int j) {
        long swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static long timestamp;

    //---------------------------------------------
    //---------- This is the main method ----------
    //---------------------------------------------
    public static void main(String[] args) {

// TODO: set this flag to true when you want to test your
        // methods with an ordered array (corner case!)
        boolean useOrderedArray = false;

        // run experiments
        final int BUBBLE = 0, SELECT = 1, INSERT = 2, QUICK = 3, QUICKOPT = 4, MERGEREC = 5, MERGENONREC = 6, MERGELINKEDLIST = 7;
        int[] algorithms = {BUBBLE, SELECT, INSERT, MERGEREC, MERGENONREC, MERGELINKEDLIST, QUICK, QUICKOPT};

        // max defines the maximum size of the array to be tested, which is 2^max
        // runs defines the number of rounds to be performed per test, in order to get an average running time.
        int max = 14, runs = 5;
        double[][] stats = new double[algorithms.length][max];
        MyLinkedList list; //for MergeSortLL
        for(int i=0; i < algorithms.length; i++) {  //loop through each sorting algorithm
            switch(i) {
                case BUBBLE: System.out.print("Running Bubble Sort ..."); break;
                case SELECT: System.out.print("Running Selection Sort ..."); break;
                case INSERT: System.out.print("Running Insertion Sort ..."); break;
                case QUICK: System.out.print("Running Quicksort..."); break;
                case QUICKOPT: System.out.print("Running Optimized Quicksort..."); break;
                case MERGEREC: System.out.print("Running MergeSort Recursive ..."); break;
                case MERGENONREC: System.out.print("Running MergeSort Non Recursive ..."); break;
                case MERGELINKEDLIST: System.out.print("Running MergeSort for Linked List ..."); break;
            } //end of switch
            for(int j = 0; j < max; j++) { //loop through each array size
                double avg = 0;
                for(int k = 0; k < runs; k++) { //loop through each run
                    int n = (int) Math.pow(2, j+1);
                    long[] a;
                    if(useOrderedArray){ a = orderedArray(n); }
                    else { a = randArray(n); }

                    list = new MyLinkedList(); //for MergeSortLL
                    copyArrayToLinkedList(a, list); //for MergeSortLL

                    startTimer();
                    switch(i) {
                        case BUBBLE: BubbleSort(a); break;
                        case SELECT: SelectionSort(a); break;
                        case INSERT: InsertionSort(a); break;
                        case MERGEREC: MergeSort(a); break;
                        case MERGENONREC: MergeSortNonRec(a); break;
                        case MERGELINKEDLIST: MergeSortLL(list); break;
                        case QUICK: QuickSort(a); break;
                        case QUICKOPT: QuickSortOptimized(a); break;
                    }
                    avg += endTimer();
                    // if this was MergeSortLL, copy list back to array
                    if( i == MERGELINKEDLIST ) a = list.toArray();

                    if (testSort(a) == false)
                        System.out.println("The sorting is INCORRECT!" + "(N=" + a.length + ", round=" + k + ").");
                }//end of k runs
                avg /= runs;
                stats[i][j] = avg;
            }//end of max array sizes
            System.out.println("done.");
        }//done running all sorting algorithms!

        DecimalFormat format = new DecimalFormat("0.0000");
        System.out.println();
        System.out.println("Average running time:");
        System.out.println("N\t Bubble Sort\t Selection Sort\tInsertion Sort\tQuickSort\tQuickSortOpt\tMergeSortRec\tMergeSortNon\tMergeSortList");
        for(int i=0; i<stats[0].length; i++) {
            System.out.print((int) Math.pow(2, i+1) + "\t  ");
            for(int j=0; j<stats.length; j++) {
                System.out.print(format.format(stats[j][i]) + "\t  ");
            }
            System.out.println();
        }
    }//end of main method

}//end of class
