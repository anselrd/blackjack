package com.deezboiz.blackjack.engine;

import java.util.HashMap;

public class Card {

    public enum Suit {
        SPADES, CLUBS, HEARTS, DIAMONDS
    }
    private static HashMap<Suit, String> suitNames = new HashMap<>();
    static {
        suitNames.put(Suit.SPADES, "Spades");
        suitNames.put(Suit.CLUBS, "Clubs");
        suitNames.put(Suit.HEARTS, "Hearts");
        suitNames.put(Suit.DIAMONDS, "Diamonds");
    }

    private Suit suit;

    Rank getRank() {
        return rank;
    }

    private Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    int[] getPointValues() {
        return rank.getValues();
    }

    @Override
    public String toString() {
        return rank + " of " + suitNames.get(suit);
    }

    boolean equals(Card card1) {
        return (this.getRank().equals(card1.getRank()));
    }
}
