package proj4;
import static proj4.Testing.*;

public class CardTester {
    public static void main(String[] args) {
        startTests();
        testCardMethods();
        testStringCardMethods();
        testIntCardMethods();
        finishTests();
    }
    private static void testCardMethods() {
        Card card1 = new Card(4, "Spades");
        String suit = card1.getSuit();
        assertEquals("Check the suit, Spades", suit, "Spades");
        int rank = card1.getRank();
        assertEquals("Check the rank, 4", rank, 4);
        String cardString = card1.toString();
        assertEquals("Check the toString method", "4 of Spades", cardString);
    }

    private static void testStringCardMethods() {
        Card card2 = new Card("4", "Spades");
        String suit2 = card2.getSuit();
        assertEquals("Check the suit, Spades", suit2, "Spades");
        int rank2 = card2.getRank();
        assertEquals("Check the rank, 4", rank2, 4);
        String card2String = card2.toString();
        assertEquals("Check the toString method", "4 of Spades", card2String);
    }

    private static void testIntCardMethods(){
        Card card3 = new Card(4, 0);
        String suit3 = card3.getSuit();
        assertEquals("Check the suit, Spades", suit3.toLowerCase(), "spades");
        System.out.println(suit3);
        int rank3 = card3.getRank();
        assertEquals("Check the rank, 4", rank3, 4);
        String card3String = card3.toString();
        assertEquals("Check the toString method", "4 of SPADES", card3String);
    }
}
