package com.deezboiz.blackjack.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        this.players.add(new Player( "Cassy"));
        this.dealer = new Player("Dealer");
    }

    public void playGame() {
        while (isActive) {
            playRound();
            cleanRound();
        }
    }

    private void playRound() {
        placeBets();
        dealInitialRound();
        for (Player player : players) {
            System.out.println(player.getName());
            System.out.println("");
            doPlayerRound(player);
        }
        doPlayerRound(dealer);
        //printGameStatus();
    }

    private void tearDownHands() {
        for (Player player : players) {
            player.resetHands();
        }
        dealer.resetHands();
    }

    private void cleanRound() {
//        gameDeck.decideToShuffle(players.size() + 1); Should shuffle (i.e. create new deck) if a certain amount of cards left in deck
        tearDownHands();
        this.isActive = false; // just to prevent infinite loops for now
    }

    private void placeBets() {
//        for (Player player : players) {
//            for (Hand hand : player.getHands()) {
//                hand.setBet(10);
//            }
//        }
    }

    private void dealInitialRound() {
        for (Player player : players) {
            player.addHand(new Hand());
            player.getActiveHand().add(gameDeck.deal());
            player.getActiveHand().add(gameDeck.deal());
        }
        dealer.addHand(new Hand());
        dealer.getActiveHand().add(gameDeck.deal());
        dealer.getActiveHand().add(gameDeck.deal());
    }

    private void doPlayerRound(Player player) {
        for (boolean stillPlaying = true; stillPlaying; stillPlaying = player.isInPlay()) playActiveHand(player);
    }

    private void playActiveHand(Player player) {
        while (player.isInPlay()) {
            String playerChoice = getPlayerChoice(player.getActiveHand());
            switch (playerChoice) {
                case "hit" :
                    player.getActiveHand().add(gameDeck.deal());
                    break;
                case "stay" :
                    player.getActiveHand().stay();
                    break;
                case "split" :
                    player.trySplittingActiveHand();
                    break;
                default :
                    System.out.println("You did a bad thing and I don't know how to do exception handling in Java!");
                    break;
            }
        }
    }

    private String getPlayerChoice(Hand hand) {
        Scanner in = new Scanner(System.in);
        System.out.println(hand);
        System.out.println("What do you want to do? (Hit/Stay/Split):\n");
        return in.nextLine().toLowerCase();
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
