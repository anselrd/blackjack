package com.deezboiz.blackjack.ui_manager;

import com.deezboiz.blackjack.engine.Action;
import com.deezboiz.blackjack.engine.Hand;

public abstract class InputHandler {

    public abstract Action getPlayerChoice(Hand disHand);

    public abstract void reportError(String errorMessage);

}
