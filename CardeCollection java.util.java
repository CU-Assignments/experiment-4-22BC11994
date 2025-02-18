import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public void displayCard() {
        System.out.println(rank + " of " + suit);
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}

public class CardCollection {

    static Collection<Card> deckOfCards = new ArrayList<>();

    public static void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

