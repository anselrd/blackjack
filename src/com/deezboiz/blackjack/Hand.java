package com.deezboiz.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();
    private Player owner;

    private int bet;

    // @TODO implement an enum here probably
    private int status; // 0 = active, 1 = stay, 2 = bust

    public Hand() {
        this.status = 0;
    }

    public void add(Card card) {
        cards.add(card);
    }

//    public int getValue() {
//        int handValue = 0;
//        cards.stream().forEach((card) -> {
//            handValue += card.getRank().
//        });
//        return handValue;
//    }

    public boolean isBust() {
        return getLowestValue() > 21;
    }

    public boolean isBlackjack() {
        return (getLowestValue() == 21 || getHighestValue() == 21);
    }

    private int getLowestValue() {
        int handValue = 0;
        for (Card card : cards){
            handValue += Arrays.stream(card.getPointValues()).min().getAsInt();
        }
        return handValue;
    }

    private int getHighestValue() {
        int handValue = 0;
        for (Card card : cards){
            handValue += Arrays.stream(card.getPointValues()).max().getAsInt();
        }
        return handValue;
    }

    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        for (Card card : cards) {
            handString.append(card.toString());
            handString.append("\n");
        }
        handString.append("Bet: ");
        handString.append(bet);
        handString.append("\n\n");
        return handString.toString();
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getStatus() {
        return status;
    }

    public void stay() {
        this.status = 1;
    }

    public void bust() {
        this.status = 2;
    }
}