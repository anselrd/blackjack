package com.deezboiz.blackjack;

import com.deezboiz.blackjack.engine.Game;

public class Blackjack {

    public static void main(String[] args) {

        System.out.println("Blackjack program starting...");

        Game game = new Game(2);
        game.playGame();

    }

}
