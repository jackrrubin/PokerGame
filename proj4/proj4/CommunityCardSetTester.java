package proj4;
import static proj4.Testing.*;

import java.util.ArrayList;

public class CommunityCardSetTester{
    public static void main(String[] args){
        startTests();
        testCommunityCardSet();
        testAddCard();
        testGetIthCard();
        finishTests();
    }

    public static void testCommunityCardSet(){
        Card c1 = new Card(2,"Spades");
        Card c2 = new Card(2,"Diamonds");
        Card c3 = new Card(4,"Spades");
        Card c4 = new Card(8,"Hearts");
        Card c5 = new Card(12,"Diamonds");
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(c1);
        communityCards.add(c2);
        communityCards.add(c3);
        communityCards.add(c4);
        communityCards.add(c5);
        CommunityCardSet cc = new CommunityCardSet(communityCards);
        System.out.println("Prints 5 unique cards");
        System.out.println(cc);
    }

    public static void testAddCard(){
        Card c1 = new Card(2,"Spades");
        Card c2 = new Card(2,"Diamonds");
        Card c3 = new Card(4,"Spades");
        Card c4 = new Card(8,"Hearts");

        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(c1);
        communityCards.add(c2);
        communityCards.add(c3);
        communityCards.add(c4);

        CommunityCardSet cc = new CommunityCardSet(communityCards);
        System.out.println("Prints 4 unique cards");
        System.out.println(cc);
        Card c5 = new Card(12,"Diamonds");
        cc.addCard(c5);
        System.out.println("Prints 5 unique cards with the newly added card");
        System.out.println(cc);
    }

    public static void testGetIthCard(){
        Card c1 = new Card(2,"Spades");
        Card c2 = new Card(2,"Diamonds");
        Card c3 = new Card(4,"Spades");
        Card c4 = new Card(8,"Hearts");
        Card c5 = new Card(12,"Diamonds");
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(c1);
        communityCards.add(c2);
        communityCards.add(c3);
        communityCards.add(c4);
        communityCards.add(c5);
        CommunityCardSet cc = new CommunityCardSet(communityCards);
        Card ithCard = cc.getIthCard(1);
        assertEquals("Prints card at index 1", "2 of Diamonds", ithCard.toString());

    }
}
