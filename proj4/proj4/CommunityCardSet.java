package proj4;

import java.util.ArrayList;

public class CommunityCardSet {
    private ArrayList<Card> communityCards;

    /**
     * creates CommunityCardSet object
     * @param cardList, list of 5 cards
     */
    public CommunityCardSet(ArrayList<Card> cardList){
        communityCards = new ArrayList<Card>(cardList);
    }

    /**
     * adds a card to list of community cards if there are less than 5 cards in the list
     * @param c1, card object
     */
    public void addCard(Card c1){
        if(communityCards.size()<5){
            communityCards.add(c1);
        }
    }

    /**
     * gets the card at a given index
     * @param index, an int 0-4
     * @return the card at the specified index
     */
    public Card getIthCard(int index){
        return communityCards.get(index);
    }

    /**
     * string representation of community cards
     * @return community cards as a string
     */
    public String toString(){
        String toReturn = "";
        for(int i=0; i<communityCards.size(); i++){
            toReturn += communityCards.get(i).toString() + "\n";
        }
        return toReturn;
    }

    /**
     * @return list of cards in the community card object
     */
    public ArrayList<Card> getCommunityCards(){
        return communityCards;
    }
}
