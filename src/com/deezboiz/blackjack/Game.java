package com.deezboiz.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private boolean isActive;
    private List<Player> players = new ArrayList<>();
    private Deck gameDeck;
    private Player dealer;

    public Game(int numDecks) {
        this.isActive = true;
        this.gameDeck = new Deck(numDecks);
        this.players.add(new Player("Matt"));
        this.players.add(new Player("Ansel"));
        this.dealer = new Player("Dealer");
    }

    public void playGame() {
        setUpHands();
        placeBets();
        dealInitialRound();
        System.out.println(this);
        isActive = false;
    }

    private void setUpHands() {
        for (Player player : players) {
            player.addHand(new Hand());
        }
        dealer.addHand(new Hand());
    }

    private void placeBets() {
        for (Player player : players) {
            for (Hand hand : player.getHands()) {
                hand.setBet(10);
            }
        }
    }

    private void dealInitialRound() {
        for (Player player : players) {
            for (Hand hand : player.getHands()) {
                hand.add(gameDeck.deal());
                hand.add(gameDeck.deal());
            }
        }
        for (Hand hand : dealer.getHands()) {
            hand.add(gameDeck.deal());
            hand.add(gameDeck.deal());
        }
    }

    @Override
    public String toString() {
        StringBuilder gameString = new StringBuilder("Game status:\n\n");
        for (Player player : players) {
            gameString.append(player.toString());
        }
        gameString.append(dealer.toString());
        return gameString.toString();
    }

}
