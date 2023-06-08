package proj4;
import java.util.ArrayList;

import static proj4.Testing.*;
public class StudPokerHandTester {
    public static void main(String[] args) {
        startTests();
        testStudPokerHand();
        testStudPokerHandCompareTo();
        testAddCard();
        testGetIthCard();
        finishTests();
    }

    public static void testStudPokerHand(){
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

        Card c6 = new Card(10,"Hearts");
        Card c7 = new Card(7,"Diamonds");
        ArrayList<Card> studHand = new ArrayList<>();
        studHand.add(c6);
        studHand.add(c7);
        StudPokerHand s1 = new StudPokerHand(cc, studHand);
        System.out.println(s1);
        System.out.println(cc.getCommunityCards());
    }

    public static void testStudPokerHandCompareTo(){
        //community cards
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


        //stud hand 1
        Card c6 = new Card(10,"Hearts");
        Card c7 = new Card(7,"Diamonds");
        ArrayList<Card> studHand = new ArrayList<>();
        studHand.add(c6);
        studHand.add(c7);
        StudPokerHand s1 = new StudPokerHand(cc, studHand);

        //stud hand 2
        Card c8 = new Card(11,"Hearts");
        Card c9 = new Card(3,"Clubs");
        ArrayList<Card> studHand2 = new ArrayList<>();
        studHand2.add(c8);
        studHand2.add(c9);
        StudPokerHand s2 = new StudPokerHand(cc, studHand2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(cc.getCommunityCards());
        int actualAnswer = s1.compareTo(s2);
        System.out.println(actualAnswer);
        assertEquals("test compareTo function", -1 ,actualAnswer);
    }

    public static void testAddCard(){
        //community cards
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

        Card c6 = new Card(12,"Spades");
        Card c7 = new Card(12,"Clubs");
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);

        StudPokerHand s1 = new StudPokerHand(cc,hand1);
        Card c8 = new Card(6,"Diamonds");
        s1.addCard(c8);
        System.out.println(s1);
        System.out.println("Nothing should change since there are 2 cards in the card list");

        //community cards
        Card c9 = new Card(2,"Spades");
        Card c10 = new Card(2,"Diamonds");
        Card c11 = new Card(4,"Spades");
        Card c12 = new Card(8,"Hearts");
        Card c13 = new Card(12,"Diamonds");

        ArrayList<Card> communityCards2 = new ArrayList<>();
        communityCards.add(c9);
        communityCards.add(c10);
        communityCards.add(c11);
        communityCards.add(c12);
        communityCards.add(c13);
        CommunityCardSet cc2 = new CommunityCardSet(communityCards);

        Card c14 = new Card(12,"Spades");
        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(c14);


        StudPokerHand s2 = new StudPokerHand(cc2,hand2);
        Card c15 = new Card(12,"Clubs");
        s2.addCard(c15);
        System.out.println("The new card should be added to the card list");
        System.out.println(s1);
    }

    public static void testGetIthCard(){
        //create cc
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

        Card c6 = new Card(12,"Spades");
        Card c7 = new Card(12,"Clubs");
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(c1);
        hand1.add(c2);

        StudPokerHand s1 = new StudPokerHand(cc,hand1);
        Card ithCard = s1.getIthCard(1);
        System.out.println(ithCard);
        assertEquals("Return card at index 1", ithCard.toString(), "2 of Diamonds");
    }
}
