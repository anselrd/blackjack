package com.deezboiz.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

    protected List<Hand> hands = new ArrayList<>();
    protected String name;

    public Player(String name) {
        this.name = name;
        this.hands.add(new Hand());
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
}
