package CardDeck.com.java;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeckFunction deck = new DeckFunction();
        deck.shuffle(); // Optional: shuffle the deck

        // Draw 20 random cards
        List<CardData> drawnCards = deck.drawRandomCards(20);

        // Sort the drawn cards using custom comparator
        deck.sortCards(drawnCards);

        // Display sorted cards
        System.out.println("Sorted Cards:");
        for (CardData card : drawnCards) {
            System.out.println(card);
        }
    }
}

