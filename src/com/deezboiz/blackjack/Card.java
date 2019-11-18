package com.deezboiz.blackjack;

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
    private Rank rank;

    public Card(Suit suit, Rank rank) {
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
        return getRank() + " of " + suitNames.get(suit);
    }
}
