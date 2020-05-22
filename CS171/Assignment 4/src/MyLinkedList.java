/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou
*/

import java.util.*;

public class MyLinkedList
{
    /*******************************************************/
    class Node
    {
        private long data;
        private Node next;
        public Node(long data, Node next)
        {
            this.data = data;
            this.next = next;
        }
        public String toString(){ return "" + this.data; }

    }
    /********************************************************/

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize(){ return size; }

    // Returns true if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Inserts a new node at the beginning of this list
    public void addFirst(long item) {
        head = new Node(item, head);
        size++;
    }

    // Inserts a new node to the end of this list
    public void addLast(long item) {
        if( isEmpty() )
            addFirst(item);
        else
        {
            Node current = head;
            while( current.next != null ) current = current.next;
            // Now current is pointing to the last element!
            current.next = new Node(item, null);
            size++;
        }
    }

    // Returns the first element (data) in the list
    public long getFirst() {
        if( isEmpty() ) throw new NoSuchElementException();
        return head.data;
    }

    // Returns the last element (data) in the list
    public long getLast() {
        if(head == null) throw new NoSuchElementException();
        Node tmp = head;
        while(tmp.next != null) tmp = tmp.next;
        return tmp.data;
    }

    // Returns a reference to the Node at the given position,
    // assuming that node indexes start at zero
    public Node get(int pos) {
        if (head == null) throw new IndexOutOfBoundsException();
        Node tmp = head;
        for (int k = 0; k < pos; k++){
            tmp = tmp.next;
            if( tmp == null ) throw new IndexOutOfBoundsException();
        }
        return tmp;
    }

    public long[] toArray() {
        if(head == null) throw new IndexOutOfBoundsException();
        long[] result = new long[getSize()];
        int i = 0;
        for(Node tmp = head; tmp != null; tmp = tmp.next){
            result[i] = tmp.data;
            i++;
        }
        return result;
    }

    // Removes and returns the first element (data) in the list.
    public long removeFirst() {
        long temp = getFirst();
        head = head.next;
        size--;
        return temp;
    }

    // Removes the first occurrence of the specified element in this list.
    public void remove(long key) {
        if(head == null)
            throw new RuntimeException("cannot delete");

        if( head.data == key ) {
            head = head.next;
            size--;
            return;
        }

        Node cur  = head;
        Node prev = null;
        while(cur != null && cur.data != key )
        {
            prev = cur;
            cur = cur.next;
        }
        if(cur == null) throw new RuntimeException("cannot delete");
        prev.next = cur.next;
        size--;
    }

    // Returns a string representation
    public String toString() {
        String output = "";
        if(head == null) throw new NoSuchElementException();
        Node tmp = head;
        while(tmp != null) {
            output += tmp + " -> ";
            tmp = tmp.next;
        }
        output += "[NULL]";
        return output;
    }

    // Returns index of input node private method should only be used in sort method
    private int getIndex(Node head, Node node) {
        int counter = 0;

        while (head != node) {
            head = head.next;
            counter++;
        }

        return counter;
    }

    //-------------------------------------------------------------------------
    //----- Use MergeSort algorithm to sort the nodes in this linked list -----
    //-------------------------------------------------------------------------

    public Node getMiddle(Node node) {
        Node slowPointer = node;
        Node fastPointer = node;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    // MergeSort starting point
    public void mergeSort() {
        if(head == null) throw new RuntimeException("Cannot sort empty list.");
        head = sort(head);
    }

    public Node sort(Node node) {
        if (node.next == null) return null; // if there is only one node in the list, return that node
        Node mid = getMiddle(node); // set middle to middle of list with getMiddle method
        Node node2 = mid.next; // set beginning of right partitioned to node after mid
        mid.next = null; // cuts of list at mid
        sort(node); // recursive call to sort first half of split
        sort(node2); // recursive call to sort second half of split
        node = head; // resets node to new head
        merge(node, node2);// returns beginning node of new merged list
        return head; // returns head of linkedlist
    }


    public Node merge(Node left, Node right) {
        Node i = left;
        Node j = right;
        Node k;

        if (i != null && j != null) { // set k = smallest element when left and right both have elements
            if (i.data <= j.data) {
                k = i;
                i = i.next;
            } else {
                k = j;
                j = j.next;
            }
        } else if (i == null) { // if left empty return right
            return j;
        } else { // if right empty return left
            return i;
        }

        Node start = k; // set start to k

        while (i != null && j != null) { // while left and right are not empty, run through each and link in order
            if (i.data <= j.data) {
                k.next = i;
                i = i .next;
            } else {
                k.next = j;
                j = j.next;
            }
            k = k.next;
        }

        // now at least one list is empty
        if (i != null) { // if left is not empty link k to first item in left
            k.next = i;
        } else if (j != null) { // if right is not empty link k to first item in right
            k.next = j;
        } else { // if both lists are empty
            head = start; // reset list head to new smallest value
            return start; // returns beginning of new list
        }

        head = start; // reset list head to new smallest value
        return start; // returns beginning of new list
    }

    public static void main(String[] args) {
        // Test your merge sort implementation here!
        MyLinkedList list = new MyLinkedList();
        list.addLast(3);
        list.addLast(2);
        list.addLast(8);
        list.addLast(10);
        list.addLast(5);
        System.out.println("Before list.mergeSort()...");
        System.out.println(list);
        list.mergeSort();
        System.out.println("\nAfter list.mergeSort()...");
        System.out.println(list);
    }

} // End of MyLinkedList class
