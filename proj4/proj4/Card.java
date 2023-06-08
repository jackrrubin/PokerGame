package proj4; // do not erase. Gradescope expects this.

import java.util.HashMap;

public class Card {
    private int rank;
    private String suit;

    /**
     * Creates a Card object, constructor
     *
     * @param rank, int between 2-14, rank of the Card object
     * @param suit, int, suit of the Card
     */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Creates a Card with a given rank and suit.
     *
     * @param rank The rank of the card, which must be between
     *             2 and 14, inclusive.
     * @param suit The suit of the card, which must be
     *             0=SPADES, 1=HEARTS, 2=CLUBS, or 3=DIAMONDS
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suitIntToString(suit);
    }

    /**
     * Creates a Card with a given rank and suit.
     *
     * @param rank whole cards (2-10) can either be spelled
     *             out like "two" or numeric like "2".Case insenstive.
     * @param suit "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit) {
        this.rank = rankStringToInt(rank);
        this.suit = suit;
    }

    /**
     * Helper method for converting integer suits to String suits
     *
     * @param suit, Each suit is assigned a number 0-3.
     * @return String representation of the suit
     */
    private static String suitIntToString(int suit) {
        if (suit == 0) return ("SPADES");
        if (suit == 1) return ("HEARTS");
        if (suit == 2) return ("CLUBS");
        return ("DIAMONDS");
    }

    /**
     * creates hashmap to help convert string ranks to int ranks
     * @return hashMap
     */
    private static HashMap<String, Integer> rankToIntMap() {
        HashMap<String, Integer> rankToInt = new HashMap<>();
        rankToInt.put("two", 2);
        rankToInt.put("three", 3);
        rankToInt.put("four", 4);
        rankToInt.put("five", 5);
        rankToInt.put("six", 6);
        rankToInt.put("seven", 7);
        rankToInt.put("eight", 8);
        rankToInt.put("nine", 9);
        rankToInt.put("ten", 10);
        rankToInt.put("jack", 11);
        rankToInt.put("queen", 12);
        rankToInt.put("king", 13);
        rankToInt.put("ace", 14);
        return rankToInt;
    }

    /**
     * converts String rank to int
     * @param rank String representation of rank
     * @return integer representation of rank
     */
    private static int rankStringToInt(String rank) {

        if (rank.charAt(0) >= '1' && rank.charAt(0) <= '9') {
            return Integer.parseInt(rank);
        } else {
            HashMap<String, Integer> rankToInt = rankToIntMap();
            return rankToInt.get(rank.toLowerCase());
        }
    }


    /**
     * Getter method for Card Object
     *
     * @return rank of Card object
     */
    public int getRank() {
        return rank;
    }

    /**
     * Getter method for Card object
     *
     * @return suit of Card object
     */
    public String getSuit() {
        return suit;
    }

    /**
     * toString method
     *
     * @return String representation of a Card Object
     */
    public String toString() {
        if (rank > 10) {
            HashMap<String, Integer> rankToInt = rankToIntMap();
            for (String s : rankToInt.keySet()) {
                if (rankToInt.get(s) == rank) {
                    return s + " of " + suit;
                }
            }


        }
        return rank + " of " + suit;
    }
}