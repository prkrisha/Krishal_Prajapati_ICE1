import java.util.Random;
import java.util.Scanner;
/**
 * Modifier: [KRISHAL]
 * Student Number: [991711226]
 * Date: [20 SEPTEMBER 2024]
 * 
 * This class implements the card trick where a user selects a card,
 * and the program searches for it in a random hand of cards.
 */
public class CardTrick {
    
    public static void main(String[] args) {
        // Step 1: Create a hand of 7 random cards
        Card[] hand = new Card[7];
        Random random = new Random();
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};

        // Fill hand with random cards
        for (int i = 0; i < hand.length; i++) {
            int value = random.nextInt(13) + 1;  // Random value between 1 and 13
            String suit = suits[random.nextInt(4)];  // Random suit
            hand[i] = new Card(value, suit);
        }

        // Step 2: Ask user to pick a card
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (enter a number between 1 and 13): ");
        int userValue = scanner.nextInt();
        System.out.println("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.next();

        Card userCard = new Card(userValue, userSuit);
        boolean found = false;

        // Step 3: Search for the user's card in the hand
        for (Card card : hand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Step 4: Report result
        if (found) {
            System.out.println("Your card is in the hand!");
        } else {
            System.out.println("Your card is not in the hand.");
        }

        // Display the random hand
        System.out.println("Here are the cards in the hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}

class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
