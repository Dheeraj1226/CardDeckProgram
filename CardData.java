package CardDeck.com.java;

//Enum for Card Suit
enum Suit {
 SPADE, CLUB, HEART, DIAMOND
}

//Enum for Card Rank
enum Rank {
 A, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K
}

//Card class representing a single card
class CardData {
 private final Suit suit;
 private final Rank rank;

 public CardData(Suit suit, Rank rank) {
     this.suit = suit;
     this.rank = rank;
 }

 public Suit getSuit() {
     return suit;
 }

 public Rank getRank() {
     return rank;
 }

 @Override
 public String toString() {
     return rank + " of " + suit;
 }
}

