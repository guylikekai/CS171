/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Kaiwen Zhou
*/

// Import of necessary packages
import java.util.*;

// This class represents a hand of playing cards
public class CardHand {

    // Instance variables (data members) of the class CardHand
    private ArrayList<String> hearts; // ArrayList of all hearts cards in hand
    private ArrayList<String> diamonds; // ArrayList of all diamonds cards in hand
    private ArrayList<String> clubs; // ArrayList of all clubs cards in hand
    private ArrayList<String> spades; // ArrayList of all spades cards in hand

    // Default constructor with no arguments
    public CardHand() {
        hearts = new ArrayList<String>();
        diamonds = new ArrayList<String>();
        clubs = new ArrayList<String>();
        spades = new ArrayList<String>();
    }

    // Public method that takes a the rank and suit in Strings and adds the specified card to hand
    public void addCard(String r, String s) {
        switch (s) {
            case "hearts":
                hearts.add(r);
                break;
            case "diamonds":
                diamonds.add(r);
                break;
            case "clubs":
                clubs.add(r);
                break;
            case "spades":
                spades.add(r);
                break;
            default:
                System.out.println("Invalid suit");

        }
    }

    // Public method that intakes a string specifying the suit and "plays" a card of the given suit
    // - plays a card of another suit if the hand does not have a card of the given suit
    public String play(String s) {
        String card;
        switch(s) {
            case "hearts": if (hearts.isEmpty()) {
                if (diamonds.size() >= 1) {
                    card = diamonds.get(0) + " of diamonds";
                    diamonds.remove(0);
                } else if (clubs.size() >= 1) {
                    card = clubs.get(0) + " of clubs";
                    clubs.remove(0);
                } else if (spades.size() >= 1) {
                    card = spades.get(0) + " of spades";
                    spades.remove(0);
                } else {
                    return "There are no cards in hand";
                }
            } else {
                card = hearts.get(0) + " of hearts";
                hearts.remove(0);
            }
            break;
            case "diamonds": if (diamonds.isEmpty()) {
                if (hearts.size() >= 1) {
                    card = hearts.get(0) + " of hearts";
                    hearts.remove(0);
                } else if (clubs.size() >= 1) {
                    card = clubs.get(0) + " of clubs";
                    clubs.remove(0);
                } else if (spades.size() >= 1) {
                    card = spades.get(0) + " of spades";
                    spades.remove(0);
                } else {
                    return "There are no cards in hand";
                }
            } else {
                card = diamonds.get(0) + " of diamonds";
                diamonds.remove(0);
            }
            break;
            case "clubs": if (clubs.isEmpty()) {
                if (hearts.size() >= 1) {
                    card = hearts.get(0) + " of hearts";
                    hearts.remove(0);
                } else if (diamonds.size() >= 1) {
                    card = diamonds.get(0) + " of diamonds";
                    diamonds.remove(0);
                } else if (spades.size() >= 1) {
                    card = spades.get(0) + " of spades";
                    spades.remove(0);
                } else {
                    return "There are no cards in hand";
                }
            } else {
                card = clubs.get(0) + " of clubs";
                clubs.remove(0);
            }
            break;
            case "spades": if (spades.isEmpty()) {
                if (hearts.size() >= 1) {
                    card = hearts.get(0) + " of hearts";
                    hearts.remove(0);
                } else if (diamonds.size() >= 1) {
                    card = diamonds.get(0) + " of diamonds";
                    diamonds.remove(0);
                } else if (clubs.size() >= 1) {
                    card = clubs.get(0) + " of clubs";
                    clubs.remove(0);
                } else {
                    return "There are no cards in hand";
                }
            } else {
                card = spades.get(0) + " of spades";
                spades.remove(0);
            }
            break;
            default: card = "Invalid suit";
        }

        return card;
    }

    // Public method to print all the cards in the hand by suit
    public void print() {
        System.out.println("Hearts in hand:");
        System.out.println(hearts);
        System.out.println("Diamonds in hand:");
        System.out.println(diamonds);
        System.out.println("Clubs in hand:");
        System.out.println(clubs);
        System.out.println("Spades in hand:");
        System.out.println(spades);

    }

    // Testing
    public static void main(String[] args) {
        CardHand hand = new CardHand();

        // Tests addCard method
        hand.addCard("1", "hearts");
        hand.addCard("jack", "diamonds");
        hand.addCard("5", "hearts");
        hand.addCard("10", "hearts");
        hand.addCard("queen", "hearts");
        hand.addCard("3", "hearts");
        hand.addCard("4", "hearts");
        hand.addCard("8", "hearts");
        hand.addCard("6", "hearts");
        hand.addCard("6", "diamonds");
        hand.addCard("3", "diamonds");
        hand.addCard("5", "diamonds");
        hand.addCard("4", "diamonds");
        hand.addCard("king", "diamonds");
        hand.addCard("1", "diamonds");
        hand.addCard("4", "clubs");

        // Tests print() method
        hand.print();

        // Tests play method
        System.out.println(hand.play("hearts"));
        System.out.println(hand.play("spades"));

        // Tests removal of played cards
        hand.print();
    }
}
