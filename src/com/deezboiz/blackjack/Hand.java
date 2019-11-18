package com.deezboiz.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();
    private Player owner;

    public void add(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int handValue = 0;
        
        return handValue;
    }

    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder("My hand has:\n");
        for (Card card : cards) {
            handString.append(card.toString());
            handString.append("\n");
        }
        return handString.toString();
    }
}
