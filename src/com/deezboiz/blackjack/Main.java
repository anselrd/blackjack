package com.deezboiz.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main program starting...");

        Deck gameDeck = new Deck(1);
        Dealer dealer = new Dealer();

        // Potentially do this better
        Player matt = new Player("Mattyroo");
        Player ansel = new Player("poopyboi");
        List<Player> players = new ArrayList<>();
        players.add(matt);
        players.add(ansel);


        dealer.dealInitialHand(gameDeck, dealer);
        dealer.dealInitialHand(gameDeck, matt);
        dealer.dealInitialHand(gameDeck, ansel);




    }

    public
}
