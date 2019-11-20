package com.deezboiz.blackjack.engine;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Hand> hands = new ArrayList<>();
    private String name;

    Player(String name) {
        this.name = name;
    }
    public void placeBet(int bet, Hand hand) {
        hand.setBet(bet);
    }

    public void dealToHand(Deck deck, Hand hand) {
        hand.add(deck.deal());
    }

    public void addHand(Hand hand) {
        hands.add(hand);
    }

    void resetHands() {
        hands.clear();
        hands.add(new Hand());
    }

    public String getName() {
        return name;
    }

    List<Hand> getHands() {
        return hands;
    }

    @Override
    public String toString() {
        StringBuilder playerString = new StringBuilder("Player: ");
        playerString.append(this.name);
        playerString.append("\n\n");
        int i = 1;
        for (Hand hand : hands) {
            playerString.append("Hand ");
            playerString.append(i);
            playerString.append(":\n");
            playerString.append(hand.toString());
            playerString.append("\n");
        }
        return playerString.toString();
    }
}
