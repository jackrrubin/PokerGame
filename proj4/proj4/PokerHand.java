package proj4; // do not erase. Gradescope expects this.

import java.util.ArrayList;
public class PokerHand {

    private ArrayList<Card> hand;
    private int handVal;

    /**
     * PokerHand object constructor. handVal is what type of hand it is, 1 = High card for default case.
     * @param cardList, ArrayList of Card objects
     */
    public PokerHand(ArrayList<Card> cardList){
        handVal = 1;
        hand = new ArrayList<>(cardList);
    }

    /**
     * Helper method that creates a rank list from a Poker Hand object
     * @return an ArrayList of all the ranks in Poker Hand
     */
    private ArrayList<Integer> rankList(){
        ArrayList<Integer> listOfRanks = new ArrayList<Integer>();
        for(int i=0; i<5; i++){
            listOfRanks.add(hand.get(i).getRank());
        }
        return listOfRanks;
    }

    /**
     * Helper method that creates a suit list from a PokerHand object
     * @return an ArrayList of all the suits in Poker Hand
     */

    private ArrayList<String> suitList(){
        ArrayList<String> listOfSuits = new ArrayList<String>();
        for(int i=0; i<5; i++){
            listOfSuits.add(hand.get(i).getSuit());
        }
        return listOfSuits;

    }

    /**
     * Helper method, frequency list that keeps trqck of the occurrences of each rank.
     * @return Array of frequencies
     */
    private int[] freqList(){
        int[] frequencyList = new int[13];
        for(int i=0; i<5; i++){
            frequencyList[hand.get(i).getRank()-2] += 1;
        }
        return frequencyList;
    }

    /**
     * Checks if Poker Hand is a flush. If yes, handVal is set to 4, otherwise nothing changes.
     */
    private void isFlush() {
        ArrayList<String> suitListCopy = new ArrayList<String>(suitList());
        String firstSuit = suitListCopy.get(0);
        for (String suit : suitListCopy) {
            if (!suit.equals(firstSuit)) {
                return;
            }
        }
        handVal = 4;
    }

    /**
     * Checks if Poker Hand has a two Pair. If yes, handVal is set to 3, otherwise nothing changes.
     */
    private void isTwoPair() {
        ArrayList<Integer> rankListCopy = new ArrayList<Integer>(rankList());
        int pairCount = 0;

        while (rankListCopy.size() != 0) {
            int currentRank = rankListCopy.get(0);
            rankListCopy.remove(0);
            if (rankListCopy.contains(currentRank)) {
                pairCount++;
                int index = rankListCopy.indexOf(currentRank);
                rankListCopy.remove(index);
            }
        }

        if (pairCount == 2) {
            handVal = 3;
        }
    }

    /**
     * checks the Poker Hand for a pair. If yes, changes handVal to 2. Otherwise, nothing changes.
     */
    private void isPair() {
        ArrayList<Integer> rankListCopy = new ArrayList<Integer>(rankList());

        while (rankListCopy.size() != 0) {
            int currentRank = rankListCopy.get(0);
            rankListCopy.remove(0);
            if (rankListCopy.contains(currentRank)) {
                handVal = 2;
                return;
            }
            handVal = handVal;
        }
    }

    /**
     * evaluates the PokerHand object by running each helper method
     */
    private void evalHand(){
        isPair();
        isTwoPair();
        isFlush();
    }

    /**
     * Breaks a high card tie between two PokerHand objects
     * @param other PokerHand object
     * @return 1 if this hand is better, -1 if other hand is better, 0 if the hands are the same.
     */
    private int breakHighCardTie(PokerHand other) {
        int[] selfFreq = freqList();
        int[] otherFreq = other.freqList();
        for (int num = 12; num >= 0; num--) {
            if (selfFreq[num] != 0 && otherFreq[num] == 0) {
                return 1;
            }
            if (selfFreq[num] == 0 && otherFreq[num] != 0) {
                return -1;
            }
        }
        return 0;
    }
    /**
     * Breaks a pair tie between two PokerHand objects
     * @param other PokerHand object
     * @return 1 if this hand is better, -1 if other hand is better, 0 if the hands are the same.
     */
    private int breakPairTie(PokerHand other) {
        int[] selfFreq = freqList();
        int[] otherFreq = other.freqList();
        int selfHighRank = 0;
        int otherHighRank = 0;
        for (int num = 12; num >= 0; num--) {
            if (selfFreq[num] != 0 && selfHighRank == 0 && otherFreq[num] == 0) {
                selfHighRank = num;
            }
            if (otherFreq[num] != 0 && otherHighRank == 0 && selfFreq[num] == 0) {
                otherHighRank = num;
            }

            if (selfFreq[num] >= 2 && !(otherFreq[num] >= 2)) {
                return 1;
            }
            if (!(selfFreq[num] >= 2) && otherFreq[num] >= 2) {
                return -1;
            }
        }
        if (selfHighRank > otherHighRank) {
            return 1;
        } else if (selfHighRank < otherHighRank) {
            return -1;
        }
        return 0;
    }

    /**
     * Breaks a flush tie between two PokerHand objects
     * @param other PokerHand object
     * @return 1 if this hand is better, -1 if other hand is better, 0 if the hands are the same.
     */
    private int breakFlushTie(PokerHand other) {
        int[] selfFreq = freqList();
        int[] otherFreq = other.freqList();
        for (int num = 12; num >= 0; num--) {
            if (selfFreq[num] != 0 && otherFreq[num] == 0) {
                return 1;
            }
            if (selfFreq[num] == 0 && otherFreq[num] != 0) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Breaks a two pair tie between two PokerHand objects
     * @param other PokerHand object
     * @return 1 if this hand is better, -1 if other hand is better, 0 if the hands are the same.
     */
    private int breakTwoPairTie(PokerHand other) {
        int[] selfFreq = freqList();
        int[] otherFreq = other.freqList();
        int selfHighRank = 0;
        int otherHighRank = 0;
        for (int num = 12; num >= 0; num--) {
            if (selfFreq[num] != 0 && selfHighRank == 0 && otherFreq[num] == 0) {
                selfHighRank = num;
            }
            if (otherFreq[num] != 0 && otherHighRank == 0 && selfFreq[num] == 0) {
                otherHighRank = num;
            }

            if (selfFreq[num]/2 > otherFreq[num]/2) {
                return 1;
            }
            if (selfFreq[num]/2 < otherFreq[num]/2) {
                return -1;
            }
        }
        if (selfHighRank > otherHighRank) {
            return 1;
        } else if (selfHighRank < otherHighRank) {
            return -1;
        }
        return 0;
    }

    /*
    adds card object to a Poker Hand object, if the Poker Hand object doesn't have 5 Card objects
    :param card: Card object
    */
    public void addCard(Card card) {
        if (hand.size() < 5) {
            this.hand.add(card);
        }
    }
    /*
    gets a card object from Poker Hand object at specified index. Must be a valid index. Returns the card
    at the index or null if not valid
    :param card: Card object
    */
    public Card getCard(int index) {
        // Check if index is valid
        if (index < 0 || index >= this.hand.size()) {
            return null;
        }

        // Return the card at the specified index
        return this.hand.get(index);
    }

    /**
     * @return String representation of toString
     */
    public String toString() {
        String toReturn = "";
        for(int i=0; i<5; i++){
            toReturn += hand.get(i).toString() + "\n";
        }
        return toReturn;
    }

    /**
     *  Determines how this hand compares to another hand, returns
     *  positive, negative, or zero depending on the comparison.
     *  @param other The hand to compare this hand to
     *  @return a negative number if this is worth LESS than other, zero
     *  if they are worth the SAME, and a positive number if this is worth
     *  MORE than other
     */
    public int compareTo(PokerHand other) {
        this.evalHand();
        other.evalHand();
        if (this.handVal > other.handVal) {
            return 1;
        } else if (this.handVal < other.handVal) {
            return -1;
        } else {
            if (this.handVal == 1) {
                return this.breakHighCardTie(other);
            } else if (this.handVal == 2) {
                return this.breakPairTie(other);
            } else if (this.handVal == 3) {
                return this.breakTwoPairTie(other);
            } else {
                return this.breakFlushTie(other);
            }
        }
    }
}