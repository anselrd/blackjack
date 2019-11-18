package com.deezboiz.blackjack;

public class Dealer extends Player {

    public void deal(Deck deck, Player player){
        player.dealToHand(deck.deal());
    }

    public Hand getHand() {
        return this.hand;
    }

}
