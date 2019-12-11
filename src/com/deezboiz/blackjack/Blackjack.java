package com.deezboiz.blackjack;

import com.deezboiz.blackjack.engine.Game;
import com.deezboiz.blackjack.ui_manager.TerminalUIHandler;

public class Blackjack {

    public static void main(String[] args) {

        System.out.println("Blackjack program starting...");

        Game game = new Game(1, new TerminalUIHandler());

        game.playGame();

    }

}
