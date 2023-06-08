package proj4; // do not erase. Gradescope expects this.

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck;
    private int nextToDeal;
    private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    /**
     * Creates a Deck object. each Deck contains an ArrayList of card objects
     * sets nextToDeal to 0, which is the index of the next card that'll be dealt.
     */
    public Deck(){
        nextToDeal = 0;
        deck = new ArrayList<>();
        for(int rank = 2; rank<=14; rank++){
            for(int suit = 0; suit<=3; suit++){
                Card c = new Card(rank, suits[suit]);
                deck.add(c);
            }
        }
    }

    /**
     *
     * @return an ArrayList of 52 Card objects
     */
    public ArrayList<Card> getDeck(){
        return deck;
    }

    /**
     * Shuffles the deck by following dealing without removing
     */
    public void shuffle() {
        for(int pos = nextToDeal; pos<52; pos++){
            int difference = 51-nextToDeal;
            int num = (int)(Math.random()*difference+nextToDeal);
            Card tempCard = new Card(deck.get(pos).getRank(), deck.get(pos).getSuit());
            deck.set(pos, deck.get(num));
            deck.set(num, tempCard);
        }
    }

    /**
     * Deals a card from a Deck object
     * @return Card object
     */
   public Card deal(){
        return deck.get(nextToDeal++);
    }

    /**
     * @return the size of the deck
     */
    public int size(){
        return deck.size()-nextToDeal;
    }

    /**
     * sets nextToDeal to 0, which indicates which index in the ArrayList is the next to be dealt.
     */
    public void gather()
    {
        nextToDeal = 0;
    }


    /**
     * checks if the deck is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty(){
        if(deck.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * @return String representation for Deck object
     */
    public String toString() {
        String toReturn = "";
        for(int i=nextToDeal; i<52; i++){
            toReturn += deck.get(i).toString() + "\n";
        }
        return toReturn;
    }
}