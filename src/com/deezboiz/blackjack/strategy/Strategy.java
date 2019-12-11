package com.deezboiz.blackjack.strategy;

import com.deezboiz.blackjack.engine.Action;
import com.deezboiz.blackjack.engine.Card;
import com.deezboiz.blackjack.engine.Hand;

public abstract class Strategy {

    private int numDecks;

    public Strategy(int numDecks){
        this.numDecks = numDecks;
    }

    public abstract Action getAction(Hand hand, Card dealerUpCard);

}