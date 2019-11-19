package com.deezboiz.blackjack;

import java.util.List;

public class Game {

    private boolean isActive;
    private List<Player> players;
    private Deck gameDeck;
    private Player dealer;

    public Game(int numDecks) {
        this.isActive = true;
        this.gameDeck = new Deck(numDecks);
        this.players.add(new Player("matt"));
        this.players.add(new Player( "ansel"));
        this.dealer = new Player("dealer");
    }

    public void playGame() {
        // do betting here
        dealInitialRound();
        while (isActive) {
            doRound();
        }
    }

    // create bet method here

    private void dealInitialRound() {
        for (Player player : players) {
            player.addHand(new Hand());
            player.dealToHand(gameDeck, player.getHand);
        }
        dealer.addHand(new Hand());
        dealer.

    }

    private void doRound() {

    }

}
