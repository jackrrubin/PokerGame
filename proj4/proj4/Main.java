package proj4;

//I affirm that I have carried out the attached academic endeavors with full academic honesty. @Jack Rubin

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * runs the Poker Game
     */
    public static void main(String[] args) {
        Deck d1 = new Deck();
        d1.shuffle();

        ArrayList<Card> communityCardsContents = new ArrayList<>();

        int STUD_HAND_SIZE = 2;
        int COMMUNITY_HAND_SIZE = 5;

        for (int i = 0; i < COMMUNITY_HAND_SIZE; i++) {
            communityCardsContents.add(d1.deal());
        }

        CommunityCardSet c1 = new CommunityCardSet(communityCardsContents);
        ArrayList<Card> hand1 = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);
        int playerScore = 0;

        while (!gameOver && d1.size() > COMMUNITY_HAND_SIZE * 2) {
            hand1 = new ArrayList<>();
            hand2 = new ArrayList<>();

            for (int i = 0; i < STUD_HAND_SIZE; i++) {
                hand1.add(d1.deal());
                hand2.add(d1.deal());
            }

            StudPokerHand s1 = new StudPokerHand(c1, hand1);
            StudPokerHand s2 = new StudPokerHand(c1, hand2);
            System.out.println("The community cards are:");
            for (Card c : communityCardsContents) {
                if(communityCardsContents.indexOf(c) < communityCardsContents.size()-1) {
                    System.out.print(c.toString() + " | ");
                } else{
                    System.out.print(c.toString());
                }

            }
            System.out.println("\n");
            System.out.println("Which of the following hands is worth more?");
            System.out.println("Hand a:");

            for (Card c : hand1) {
                if(hand1.indexOf(c) < hand1.size()-1) {
                    System.out.print(c.toString() + ", ");
                }else{
                    System.out.print(c.toString());
                }
            }
            System.out.println();
            System.out.println("or");
            System.out.println("Hand b:");

            for (Card c : hand2) {
                if(hand2.indexOf(c) < hand2.size()-1) {
                    System.out.print(c.toString() + ", ");
                }else{
                    System.out.print(c.toString());
                }
            }
            System.out.println("\n");
            System.out.println("Enter a or b (or SPACE to indicate they are of equal value)");
            String playerGuess = input.nextLine();
            int convertedPlayerGuess = 0;

            int correctAnswer = s1.compareTo(s2);

            if (playerGuess.equals("a")) {
                convertedPlayerGuess = 1;
            } else if (playerGuess.equals("b")) {
                convertedPlayerGuess = -1;
            }

            System.out.println("got input: " + playerGuess);

            if (correctAnswer == convertedPlayerGuess) {
                System.out.println("CORRECT!!!");
                playerScore++;
            } else {
                System.out.println("WRONG!!!");
                System.out.println("Points: " + playerScore);
                gameOver = true;
            }
            System.out.println();
        }
    }
}