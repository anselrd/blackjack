package com.deezboiz.blackjack;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main program starting...");

        Deck gameDeck = new Deck(1);
        Dealer dealer = new Dealer();
        dealer.deal(gameDeck, dealer);
        dealer.deal(gameDeck, dealer);
        System.out.println(dealer.getHand());


    }

}
