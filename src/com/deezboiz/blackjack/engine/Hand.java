package com.deezboiz.blackjack.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();
    private Player owner;

    private int bet;

    private enum status {
        ACTIVE, STAY, BUST
    }
    private status handStatus = status.ACTIVE;

    private boolean inPlay = true;

    Hand(){}

    Hand(Card card) {
        cards.add(card);
    }

    void add(Card card) {
        cards.add(card);
        recomputeNonOptionalStatus();
    }

    private void recomputeNonOptionalStatus() {
        if (isBust()) handStatus = status.BUST;
        if (isBlackjack()) handStatus = status.STAY;
        inPlay = handStatus == status.ACTIVE;
    }

    private boolean isBust() {
        return getLowestValue() > 21;
    }

    private boolean isBlackjack() {
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

    void setBet(int bet) {
        this.bet = bet;
    }

    void stay() {
        handStatus = status.STAY;
        inPlay = false;
    }

    Card split() {
        Card split = cards.get(0);
        cards.remove(0);
        return split;
    }

    boolean isInPlay() {
        return inPlay;
    }

}