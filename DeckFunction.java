package CardDeck.com.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Deck class to manage the deck of cards
class DeckFunction {
    private List<CardData> cards;

    public DeckFunction() {
        cards = new ArrayList<>();
        // Initialize the deck with all 52 cards
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new CardData(suit, rank));
            }
        }
    }

    // Method to draw a random card from the deck
    public CardData drawRandomCard() {
        Random random = new Random();
        int index = random.nextInt(cards.size());
        return cards.remove(index);
    }

    // Method to draw 20 random cards from the deck
    public List<CardData> drawRandomCards(int numCards) {
        List<CardData> drawnCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            drawnCards.add(drawRandomCard());
        }
        return drawnCards;
    }

    // Method to shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Custom comparator for sorting cards based on color, suit, and rank
    public static class CardComparator implements java.util.Comparator<CardData> {
        @Override
        public int compare(CardData card1, CardData card2) {
            // First compare by color (Red before Black)
            int colorComparison = getColorValue(card1.getSuit()) - getColorValue(card2.getSuit());
            if (colorComparison != 0) {
                return colorComparison;
            }

            // Then compare by suit within each color
            int suitComparison = card1.getSuit().compareTo(card2.getSuit());
            if (suitComparison != 0) {
                return suitComparison;
            }

            // Finally compare by rank (ascending)
            return card1.getRank().compareTo(card2.getRank());
        }

        // Helper method to determine color value for comparison
        private int getColorValue(Suit suit) {
            if (suit == Suit.HEART || suit == Suit.DIAMOND) {
                return 0; // Red color
            } else {
                return 1; // Black color
            }
        }
    }

    // Method to sort a list of cards using the custom comparator
    public void sortCards(List<CardData> cardsToSort) {
        Collections.sort(cardsToSort, new CardComparator());
    }
}

