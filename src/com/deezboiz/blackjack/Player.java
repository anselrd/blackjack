package com.deezboiz.blackjack;

public class Player {

    protected Hand hand = new Hand();
    protected String name;

    public void dealToHand(Card card) {
        hand.add(card);
    }

}
