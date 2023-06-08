package proj4;

import java.util.ArrayList;

public class StudPokerHand {
    private CommunityCardSet communityCards;
    private ArrayList<Card> listOfCards;
    private ArrayList<Card> playingCards;

    /**
     * creates stud poker hand object
     * @param cc community cards
     * @param cardList list of two cards, player cards
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList){
        communityCards = cc;
        listOfCards = cardList;

        playingCards = new ArrayList<>(cardList);
        playingCards.addAll(cc.getCommunityCards());
    }

    /**
     * adds card to player's hand if there is less than 2
     * @param c1, card object
     */
    public void addCard(Card c1){
        if(listOfCards.size()<2){
            listOfCards.add(c1);
            playingCards.add(c1);
        }

    }

    /**
     * gets card at a specified index
     * @param index, int 0-1
     * @return card object at specified index
     */
    public Card getIthCard(int index){
        return listOfCards.get(index);
    }

    /**
     * String representation of stud poker hand
     * @return
     */
    public String toString(){
        String toReturn = "";
        for(int i=0; i<2; i++){
            toReturn += listOfCards.get(i).toString() + "\n";
        }
        return toReturn;
    }

    /**
     * 7 choose 5 = 21 hands. Produces 21 unique 5 card poker hands
     * @return the list of 21 unique 5 card poker hands
     */
    private ArrayList<PokerHand> getAllFiveCardHands()
    {
        ArrayList<Card> gameCards = new ArrayList<>();
        gameCards.addAll(communityCards.getCommunityCards());
        gameCards.addAll(listOfCards);
        ArrayList<PokerHand> allFiveCardHandsList = new ArrayList<PokerHand>();

        for(int i=0; i<gameCards.size()-1; i++){
            for(int j=i+1; j<gameCards.size(); j++){
                ArrayList<Card> fiveCardHandList = new ArrayList<>(gameCards);
                fiveCardHandList.remove(j);
                fiveCardHandList.remove(i);
                PokerHand fiveCardHand = new PokerHand(fiveCardHandList);
                allFiveCardHandsList.add(fiveCardHand);

            }
        }
        return allFiveCardHandsList;
        }

    /**
     * finds the best five card hand out of the list of 21 hands
      * @return the best PokerHand
     */
    private PokerHand getBestFiveCardHand()
    {
        ArrayList<PokerHand> hands = new ArrayList<PokerHand>(getAllFiveCardHands());
        PokerHand bestSoFar = hands.get(0);

        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }


    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other){
        PokerHand thisHand = getBestFiveCardHand();
        PokerHand otherHand = other.getBestFiveCardHand();
        return thisHand.compareTo(otherHand);
    }
}
