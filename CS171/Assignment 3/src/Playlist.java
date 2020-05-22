/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. Kaiwen Zhou
*/

/*  This class represents a Playlist of podcast episodes, where each
/*  episode is implemented as an object of type Episode. A user navigating
/*  a Playlist should be able to move between songs using Next or Previous.
/*
/*  To enable flexible navigation, the Playlist is implemented as
/*  a Circular Doubly Linked List where each episode has a link to both
/*  the next and the prev episodes in the list.
/*
/*  Additionally, the last Episode is linked to the head of the list (via next),
/*  and the head of the list is linked to that last Episode (via prev). That said,
/*  there is NO special "last" reference keeping track of the last Episode.
/*  But there is a "head" reference that should always refer to the first Episode.
*/

public class Playlist
{
    // private fields: head = beginning of playlist; size = size of playlist
    private Episode head;
    private int size;

    // default constructor
    public Playlist()
    {
        head = null;
        size = 0;
    }

    // method to check if the playlist is empty
    public boolean isEmpty()
    {
        return head == null;
    }


    // get method for size of playlist
    public int getSize()
    {
        return this.size;
    }

    // displays the Episodes starting from the head and moving forward
    public void displayPlaylistForward()
    {
        String output = "[BEGIN] ";
        Episode current = head;

        // attaches episodes to output string consecutively until the next episode is head
        while( current.next != head ){
            output += current + " -> ";
            current = current.next;
        }

        // attaches last episode to output string and prints
        output += current + " [END]\n";
        System.out.println(output);
    }


    // displays the Episodes starting from the end and moving backwards
    public void displayPlaylistBackward() {
        if (size > 0) {
            String output = "[END] ";
            Episode current = head.prev;

            // attaches episode to output string in backwards consecutive order until the next one is head
            while (current.prev != head) {
                output += current + " -> ";
                current = current.prev;
            }

            // print case for when the playlist is only one item long
            if (size == 1) {
                output += current + " [BEGIN]\n";
                System.out.println(output);
            } else { // print case for >1  length playlist
                output += current + " -> " + head + " [BEGIN]\n";
                System.out.println(output);
            }

        } else { // throw exception for empty playlist
            throw new RuntimeException("Empty Playlist");
        }
    }

    // add a new Episode at the beginning of the Playlist
    public void addFirst( String title, double duration )
    {
        if (isEmpty()) { // add first if empty
            addLast(title, duration);
        }  else { // add first if not empty
            head.prev = new Episode(title, duration, head, head.prev);
            Episode current = head.prev;
            current.prev.next = head.prev;
            head = current;
            size++;
        }
    }

    // add a new Episode at the end of the Playlist
    public void addLast( String title, double duration ) {
        if (isEmpty()) { // add last if empty
            head = new Episode(title, duration, null, null);
            head.next = head;
            head.prev = head;
            size = 1;
        } else { // add last if not empty
            Episode current = head.prev;
            current.next = new Episode(title, duration, head, head.prev);
            head.prev = current.next;
            size++;
        }
    }

    // Add a new Episode at the given index, assuming that index
    // zero corresponds to the first node
    public void add( String title, double duration, int index)
    {
        if (index == 0) { // add if index is 0
            addFirst(title, duration);
        } else if (index == size) { // add if index is last place
            addLast(title, duration);
        } else {
                if (index > this.size) { // throw exception if index is greater than number of items in playlist
                    throw new IndexOutOfBoundsException("Index given does not exist – Cannot add to this index. Please pick an integer between 0 and " + (size - 1) + " inclusive.");
                } else { // add otherwise
                    Episode current = head;
                    int counter = 0;
                    while (counter < index) {
                        current = current.next;
                        counter++;
                    }
                    current.prev = new Episode(title, duration, current, current.prev);
                    Episode newAddition = current.prev;
                    newAddition.prev.next = newAddition;
                    size++;
                }
            }
        }

    // Delete the Episode that has the given "title"
    public Episode deleteEpisode(String title) {
        Episode current = head;
        int originalSize = size;
        if (isEmpty()) { // throw exception if playlist is empty
            throw new RuntimeException("Cannot delete episode from an empty playlist");
        } else {
            for (int i = 0; i < originalSize; i++) { // runs through playlist
                if (current.getTitle().equals(title)) { // finds the episode whose title matches given
                    if (i == 0){ // deletion if the episode is head
                        head = current.next;
                    }
                    // relink
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    break;
                } else { // go to next if title doesn't match
                    current = current.next;
                }
            }
        }
        if (originalSize == size) { // if size is the same throw exception
            throw new RuntimeException("No episode with given title found");
        } else {
            return current;
        }

    }

    // Delete every m-th Episode in the user's circular Playlist,
    // until only one Episode survives. Return the survived Episode.
    public Episode deleteEveryMthEpisode(int m) {
        if (m < 1) { // throw exception if m is less than one
            throw new RuntimeException("Invalid m");
        }
        if (isEmpty()) { // throw exception if playlist is empty
            throw new RuntimeException("Cannot deleteEveryMthEpisode in an empty Playlist");
        } else {
            Episode tempHead = head;
            while (size != 1) { // loop through playlist and delete until size = 1
                Episode current = tempHead;
                int counter = 1;
                while (counter < m){ // count to the next episode for deletion
                    current = current.next;
                    counter++;
                }
                // set next starting position for counting and delete episode to be deleted
                tempHead = current.next;
                deleteEpisode(current.getTitle());
            }
            return tempHead;
        }
    }

} // End of Playlist class
