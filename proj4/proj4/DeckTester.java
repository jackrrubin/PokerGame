package proj4;
import static proj4.Testing.*;

public class DeckTester {
    public static void main(String[] args) {
        startTests();
        testGetDeck();
        testShuffle();
        testDeal();
        testSize();
        testGather();
        testIsEmpty();
        testToString();
        finishTests();
    }

    public static void testGetDeck() {
        Deck d1 = new Deck();
        System.out.println("Prints a list of 52 unique cards");
        System.out.println(d1.getDeck());
        System.out.println();
    }

    public static void testShuffle() {
        Deck d1 = new Deck();
        System.out.println(d1.getDeck());
        System.out.println();
        d1.shuffle();
        System.out.println("Shuffled Deck:");
        System.out.println(d1.getDeck());
        System.out.println();
    }
    public static void testDeal() {
        Deck d1 = new Deck();
        System.out.println(d1.getDeck());
        Card dealtCard = d1.deal();
        assertEquals("deals a card", "2 of Clubs", dealtCard.toString());
    }
    public static void testSize() {
        Deck d1 = new Deck();
        int deckSize = d1.size();
        System.out.println(deckSize);
        assertEquals("returns size of the deck", 52 , deckSize);

    }
    public static void testGather() {
        //resets the nextToDeal to 0
        Deck d1 = new Deck();
        Card c1 = d1.deal();
        System.out.println(c1);
        Card c2 = d1.deal();
        System.out.println(c2);
        d1.gather();
        System.out.println("Should print the same values as c1 and c2 again");
        Card c3 = d1.deal();
        System.out.println(c3);
        Card c4 = d1.deal();
        System.out.println(c4);
    }

    public static void testIsEmpty() {
        Deck d1 = new Deck();
        assertEquals("A non empty deck", false, d1.isEmpty());
    }

    public static void testToString(){
        Deck d1 = new Deck();
        System.out.println(d1.toString());
        d1.deal();
        d1.deal();
        System.out.println(d1.toString());
    }
}
