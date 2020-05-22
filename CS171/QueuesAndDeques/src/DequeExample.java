import java.util.Iterator;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeExample
{
    public static void main(String[] args)
    {
        // What is happening here?
        Deque<String> deque = new ArrayDeque<String>();

        // We can add elements to the queue in various ways
        deque.add("E1");
        deque.addFirst("E2");
        deque.addLast("E3");
        deque.push("E4");
        deque.offer("E5");
        deque.offerFirst("E6");
        deque.offerLast("E7");

        System.out.println(deque + "\n");

        // (1) For-each is permissible because ArrayDeque
        // implements Iterable interface
        System.out.println("Printing using for-each:");
        for( String s : deque ){
            System.out.println(s);
        }
        System.out.println();

        // (2) Iterate through the queue elements
        System.out.println("Standard Iterator");
        // ArrayDeque has its own iterator()
        // Returns an iterator over the elements in this deque in "proper sequence."
        Iterator iterator = deque.iterator();
        while (iterator.hasNext())
            System.out.println("\t" + iterator.next() );
        //
        // (3) Reverse order iterator
        Iterator reverse = deque.descendingIterator();
        // Returns an iterator over the elements in this
        // deque in reverse order
        System.out.println("Reverse Iterator");
        while (reverse.hasNext())
            System.out.println("\t" + reverse.next());

        // (4) Peek returns the head, without deleting
        // it from the deque
        System.out.println("Peek " + deque.peek());
        System.out.println("After peek: " + deque);

        // (5) Pop returns the head, and removes it from
        // the deque
        System.out.println("Pop " + deque.pop());
        System.out.println("After pop: " + deque);

        //(6) We can check if a specific element exists
        // in the deque
        System.out.println("Contains element 3: " +
                deque.contains("E3"));

        // (7) We can remove the first / last element.
        deque.removeFirst();
        System.out.println("Deque after removing first ");
        iterator = deque.iterator();
        while (iterator.hasNext())
            System.out.println("\t" + iterator.next());

        deque.removeLast();
        System.out.println("Deque after removing " +
                "first and last: " + deque);

        // deque has been declared as type Deque (an interface can be used as a type)
        // but instantiated as an ArrayDeque object. This gives us flexibility.
        // If later in the code we decide to re-assign "deque" to another object
        // from a class that implements Deque, that is allowed:
        deque = new LinkedList<String>(); // <-- this is allowed because LinkedList implements Deque!
    }

}
