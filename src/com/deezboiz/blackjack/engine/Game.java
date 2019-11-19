package com.deezboiz.blackjack.engine;

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
        while (isActive) {
            playRound();
            cleanRound();
        }
    }

    private void playRound() {
        setUpHands();
        placeBets();
        dealInitialRound();
        printGameStatus();
    }

    private void cleanRound() {
//        gameDeck.decideToShuffle; Should shuffle (i.e. create new deck) if a certain amount of cards left in deck
        this.isActive = false; // just to prevent infinite loops for now
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

    private void printGameStatus() {
        StringBuilder gameString = new StringBuilder("Game status:\n\n");
        for (Player player : players) {
            gameString.append(player.toString());
        }
        gameString.append(dealer.toString());
        System.out.println(gameString.toString());
    }

}
