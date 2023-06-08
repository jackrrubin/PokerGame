package proj4;
import java.util.ArrayList;
import static proj4.Testing.*;

/**
 I affirm that I have carried out the attached academic endeavors with full academic honesty,
 in accordance with the Union College Honor Code and the course syllabus.
 author @ Jack Rubin
 */
public class PokerComparisonTests {

    public static void main(String[] args) {
        startTests();
        testCompareHighCardTie();
        testComparePairTieBreak();
        testCompareFlushVsPair();
        testCompareTwoPairsCaseTwo();
        testCompareTwoPairTieBreak();
        testCompareFlushes();
        testCompareFlushVsTwoPair();
        testCardMethods();
        finishTests();
    }
    private static void testCompareHighCardTie(){
        Card c1 = new Card(2,"Spades");
        Card c2 = new Card(3,"Clubs");
        Card c3 = new Card(4,"Spades");
        Card c4 = new Card(8,"Hearts");
        Card c5 = new Card(12,"Diamonds");
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);
        hand1.add(c3);
        hand1.add(c4);
        hand1.add(c5);
        PokerHand handOne = new PokerHand(hand1);
        PokerHand handTwo = new PokerHand(hand1);
        int actual = handOne.compareTo(handTwo);
        int EXPECTED = 0;
        assertEquals("High Card tie, should be 0", actual, EXPECTED);
    }

    private static void testComparePairTieBreak(){
        Card c1 = new Card(2,"Spades");
        Card c2 = new Card(2,"Diamonds");
        Card c3 = new Card(4,"Spades");
        Card c4 = new Card(8,"Hearts");
        Card c5 = new Card(12,"Diamonds");
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);
        hand1.add(c3);
        hand1.add(c4);
        hand1.add(c5);

        Card c6 = new Card(2,"Hearts");
        Card c7 = new Card(2,"Clubs");
        Card c8 = new Card(13,"Spades");
        Card c9 = new Card(6,"Hearts");
        Card c10 = new Card(8,"Diamonds");
        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(c6);
        hand2.add(c7);
        hand2.add(c8);
        hand2.add(c9);
        hand2.add(c10);

        PokerHand handOne = new PokerHand(hand1);
        PokerHand handTwo = new PokerHand(hand2);

        System.out.println(handOne.compareTo(handTwo));
        int actual = handOne.compareTo(handTwo);
        int EXPECTED = -1;
        assertEquals("Pair tie breaker, should be -1", actual, EXPECTED);
    }

    private static void testCompareFlushVsTwoPair(){
        Card c1 = new Card(2,"Spades");
        Card c2 = new Card(3,"Spades");
        Card c3 = new Card(4,"Spades");
        Card c4 = new Card(8,"Spades");
        Card c5 = new Card(12,"Spades");
        Card c6 = new Card(10,"Diamonds");
        Card c7 = new Card(10,"Clubs");
        Card c8 = new Card(2,"Clubs");

        ArrayList<Card> hand2 = new ArrayList<>();
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);
        hand1.add(c3);
        hand1.add(c4);
        hand1.add(c5);

        hand2.add(c1);
        hand2.add(c8);
        hand2.add(c3);
        hand2.add(c6);
        hand2.add(c7);
        PokerHand handOne = new PokerHand(hand1);
        PokerHand handTwo = new PokerHand(hand2);
        System.out.println(handOne.compareTo(handTwo));
        int actual = handOne.compareTo(handTwo);
        int EXPECTED = 1;
        assertEquals("Flush vs Two Pair, should be 1", actual, EXPECTED);
    }

    private static void testCompareFlushes(){
        Card c1 = new Card(12,"Spades");
        Card c2 = new Card(11,"Spades");
        Card c3 = new Card(6,"Spades");
        Card c4 = new Card(3,"Spades");
        Card c5 = new Card(2,"Spades");
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);
        hand1.add(c3);
        hand1.add(c4);
        hand1.add(c5);

        Card c6 = new Card(12,"Diamonds");
        Card c7 = new Card(13,"Diamonds");
        Card c8 = new Card(6,"Diamonds");
        Card c9 = new Card(2,"Diamonds");
        Card c10 = new Card(8,"Diamonds");
        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(c6);
        hand2.add(c7);
        hand2.add(c8);
        hand2.add(c9);
        hand2.add(c10);

        PokerHand handOne = new PokerHand(hand1);
        PokerHand handTwo = new PokerHand(hand2);
        System.out.println(handOne.compareTo(handTwo));
        int actual = handOne.compareTo(handTwo);
        int EXPECTED = -1;
        assertEquals("Flush tie break, should be -1", actual, EXPECTED);
    }

    private static void testCompareFlushVsPair(){
        Card c1 = new Card(2,"Spades");
        Card c2 = new Card(3,"Spades");
        Card c3 = new Card(4,"Spades");
        Card c4 = new Card(8,"Spades");
        Card c5 = new Card(12,"Spades");
        Card c6 = new Card(10,"Diamonds");
        Card c7 = new Card(10,"Clubs");

        ArrayList<Card> hand2 = new ArrayList<>();
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);
        hand1.add(c3);
        hand1.add(c4);
        hand1.add(c5);

        hand2.add(c1);
        hand2.add(c2);
        hand2.add(c3);
        hand2.add(c6);
        hand2.add(c7);
        PokerHand handOne = new PokerHand(hand1);
        PokerHand handTwo = new PokerHand(hand2);
        System.out.println(handOne.compareTo(handTwo));
        int actual = handOne.compareTo(handTwo);
        int EXPECTED = 1;
        assertEquals("Flush vs Pair, should be 1", actual, EXPECTED);
    }

    private static void testCompareTwoPairsCaseTwo(){
        Card c1 = new Card(14,"Spades");
        Card c2 = new Card(14,"Clubs");
        Card c3 = new Card(3,"Spades");
        Card c4 = new Card(3,"Hearts");
        Card c5 = new Card(6,"Diamonds");
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);
        hand1.add(c3);
        hand1.add(c4);
        hand1.add(c5);

        Card c6 = new Card(12,"Diamonds");
        Card c7 = new Card(12,"Clubs");
        Card c8 = new Card(12,"Spades");
        Card c9 = new Card(12,"Hearts");
        Card c10 = new Card(7,"Diamonds");
        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(c6);
        hand2.add(c7);
        hand2.add(c8);
        hand2.add(c9);
        hand2.add(c10);

        PokerHand handOne = new PokerHand(hand1);
        PokerHand handTwo = new PokerHand(hand2);
        System.out.println(handOne.compareTo(handTwo));
        int actual = handOne.compareTo(handTwo);
        int EXPECTED = 1;
        assertEquals("Two Pair Tie Break, should be 1", actual, EXPECTED);
    }

    private static void testCompareTwoPairTieBreak(){
        Card c1 = new Card(12,"Spades");
        Card c2 = new Card(12,"Clubs");
        Card c3 = new Card(6,"Spades");
        Card c4 = new Card(3,"Hearts");
        Card c5 = new Card(6,"Diamonds");
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);
        hand1.add(c3);
        hand1.add(c4);
        hand1.add(c5);

        Card c6 = new Card(12,"Diamonds");
        Card c7 = new Card(12,"Clubs");
        Card c8 = new Card(6,"Spades");
        Card c9 = new Card(6,"Hearts");
        Card c10 = new Card(8,"Diamonds");
        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(c6);
        hand2.add(c7);
        hand2.add(c8);
        hand2.add(c9);
        hand2.add(c10);

        PokerHand handOne = new PokerHand(hand1);
        PokerHand handTwo = new PokerHand(hand2);
        System.out.println(handOne.compareTo(handTwo));
        int actual = handOne.compareTo(handTwo);
        int EXPECTED = -1;
        assertEquals("Two Pair Tie Break, should be -1", actual, EXPECTED);
    }

    private static void testCardMethods(){
        Card card1 = new Card(4, "Spades");
        String suit = card1.getSuit();
        assertEquals("Check the suit, Spades", suit, "Spades");
        int rank = card1.getRank();
        assertEquals("Check the rank, 4", rank, 4);
        String cardString = card1.toString();
        assertEquals("Check the toString method", "4 of Spades", cardString);

    }


}
