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
        for (Player player : players) {
            doPlayerRound(player,gameDeck);
        }
        //players.forEach(Game::doPlayerRound); // is this just doPlayerRound(player) for each Player player in players?
        printGameStatus();
    }

    private void cleanRound() {
//        gameDeck.decideToShuffle; Should shuffle (i.e. create new deck) if a certain amount of cards left in deck
        this.isActive = false; // just to prevent infinite loops for now
    }

    private void setUpHands() {
        for (Player player : players) {
            player.resetHands();
        }
        dealer.resetHands();
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

    private static void doPlayerRound(Player player, Deck gameDeck) {
        // logic for actually playing here
        //List<Hand> splitHands = new ArrayList<>();
        // something recursive here
        Scanner in = new Scanner(System.in);
        for (Hand hand : player.getHands()) {
            if (hand.isInPlay()) {
                System.out.println(hand);
                System.out.println("What do you want to do? (Hit/Stay/Split):\n");
                String playerChoice = in.nextLine();
                switch (playerChoice) {
                    case "Hit" :
                        player.dealToHand(gameDeck,hand);
                        break;
                    case "Stay" :
                        hand.stay();
                        break;
                    case "Split" :
                        //hand.split(); deal with this later
                        break;
                    default :
                        System.out.println("You did a bad thing and I don't know how to do exception handling in Java!");
                        break;
                }
                doPlayerRound(player, gameDeck);
            }
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
