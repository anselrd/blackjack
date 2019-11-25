package com.deezboiz.blackjack.engine.strategy;

import com.deezboiz.blackjack.engine.Action;
import com.deezboiz.blackjack.engine.Card;
import com.deezboiz.blackjack.engine.Hand;

public abstract class BasicStrategy extends Strategy {

    public BasicStrategy(int numDecks) {
        super(numDecks);
    }

    @Override
    public Action getAction(Hand hand, Card dealerUpCard) {
        return null;
    }
}
