package com.deezboiz.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();
    private Player owner;

    public void add(Card card) {
        cards.add(card);
    }

//     @TODO figure this out
//    public int getValue() {
//        int handValue = 0;
//        cards.stream().forEach((card) -> {
//            handValue += card.getRank().
//        });
//        return handValue;
//    }
    public int getLowestValue() {
        int handValue = 0;
        for (Card card : cards){
            handValue += Arrays.stream(card.getPointValues()).min().getAsInt();
        }
        return handValue;
    }

    public int getHighestValue() {
        int handValue = 0;
        for (Card card : cards){
            handValue += Arrays.stream(card.getPointValues()).max().getAsInt();
        }
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
