package com.deezboiz.blackjack.engine;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Hand> hands = new ArrayList<>();
    private Hand activeHand;
    private String name;

    Player(String name) {
        this.name = name;
    }

    void placeBet(int bet, Hand hand) {
        hand.setBet(bet);
    }

    void addHand(Hand hand) {
        hands.add(hand);
        if (hands.size() == 1) activeHand = hands.get(0);
    }

    void resetHands() {
        hands.clear();
        activeHand = null;
    }

    String getName() {
        return name;
    }

    Hand getActiveHand() {
        updateActiveHand();
        return activeHand;
    }

    private void updateActiveHand() {
        activeHand = null;
        for(Hand hand : hands) {
            if (hand.isInPlay()) {
                activeHand = hand;
                break;
            }
        }
    }

    void trySplittingActiveHand() {
        if (activeHand.isSplittable()) {
            splitActiveHand();
        } else {
            System.out.println("YOU BAD BOI YOU TRIED TO SPLIT WHEN YOU CAN'T");
        }
    }

    private void splitActiveHand() {
        Card toSplit = getActiveHand().split();
        addHand(new Hand(toSplit));
    }

    boolean isInPlay() {
        for (Hand hand : hands) {
            if (hand.isInPlay()) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder playerString = new StringBuilder("Player: ").append(this.name).append("\n\n");
        int i = 1;
        for (Hand hand : hands) {
            playerString.append("Hand ")
                        .append(i)
                        .append(":\n")
                        .append(hand.toString())
                        .append("\n");
            i++;
        }
        return playerString.toString();
    }
}
