package com.deezboiz.blackjack.engine;

import com.deezboiz.blackjack.ui_manager.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private boolean isActive;
    private List<Player> players = new ArrayList<>();
    private Deck gameDeck;
    private Player dealer;
    static int theNumber = 21;
    private InputHandler daBEan;

    public Game(int numDecks, InputHandler daBeAN) {
        this.isActive = true;
        this.gameDeck = new Deck(numDecks);
        this.players.add(new Player("Matt"));
        this.players.add(new Player("Ansel"));
        this.players.add(new Player( "Cassy"));
        this.dealer = new Player("Dealer");
        this.daBEan = daBeAN;
    }

    public void playGame() {
        while (isActive) {
            playRound();
            cleanRound();
        }
    }

    private void playRound() {
        placeBets();
        gameDeck.stackTheDeck();
        dealInitialRound();
        for (Player player : players) {
            System.out.println(player.getName());
            System.out.println();
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
        gameDeck.decideToShuffle();
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
            Action playerChoice = daBEan.getPlayerChoice(player.getActiveHand());
            if (playerChoice == null) {
                daBEan.reportError("you FOOL");
                return;
            }
            switch (playerChoice) {
                case HIT:
                    player.getActiveHand().add(gameDeck.deal());
                    break;
                case STAY:
                    player.getActiveHand().stay();
                    break;
                case SPLIT:
                    player.trySplittingActiveHand(); // @TODO do nice thing if you couldn't split
                    break;
                case DOUBLE:
                    player.getActiveHand().setBet(player.getActiveHand().getBet()*2);
                    player.getActiveHand().add(gameDeck.deal());
                    player.getActiveHand().stay();
                    break;
                default:
                    daBEan.reportError("Uh oh you beaned it again (action must be HIT, STAY, SPLIT, or DOUBLE");
                    break;
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
