package com.deezboiz.blackjack.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();
    private Player owner;

    private int bet;

    private enum status {
        ACTIVE, STAY, BUST, BLACKJACK
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

    public Card getCard(int idx) {
        return cards.get(idx);
    }

    private void recomputeNonOptionalStatus() {
        if (isBust()) handStatus = status.BUST;
        if (isBlackjack()) handStatus = status.BLACKJACK;
        inPlay = handStatus == status.ACTIVE;
    }

    private boolean isBust() {
        if (getLowestValue() > Game.theNumber) {
            System.out.println("You busted you idiot");
            return true;
        } else {
            return false;
        }
    }

    private boolean isBlackjack() {
        if (getAllValues().contains(Game.theNumber)) {
            System.out.println("BLACKJACK!!!");
            return true;
        } else {
            return false;
        }
    }

    private List<Integer> getAllValues() {
        int numAces = countAces();
        List<Integer> handValues = new ArrayList<>(numAces + 1);
        int baseValue = getLowestValue();
        for (int i = 0; i < numAces + 1; i++) {
            handValues.add(i, baseValue + 10 * i);
        }
        return handValues;
    }

    private int countAces() {
        return cards.stream().mapToInt(card -> card.getRank().isSingleValued() ? 0 : 1).sum();
    }

    public boolean isSoft() {
        return countAces() > 0;
    }

    public int getLowestValue() {
        int handValue = 0;
        for (Card card : cards){
            handValue += Arrays.stream(card.getPointValues()).min().getAsInt();
        }
        return handValue;
    }

    public int getHighestPlayableValue() {
        int handvalue = getLowestValue();
        if (handvalue > Game.theNumber) {
            return -1;
        }
        handvalue += handvalue + 10 <= Game.theNumber ? 10 : 0;
        return handvalue;
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
        Card split = cards.get(1);
        cards.remove(1);
        return split;
    }

    public boolean isInPlay() {
        return inPlay;
    }

    public boolean isSplittable() {
        return cards.size() == 2 && cards.get(0).equals(cards.get(1));
    }


}