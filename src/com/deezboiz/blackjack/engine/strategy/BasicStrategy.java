package com.deezboiz.blackjack.engine.strategy;

import com.deezboiz.blackjack.engine.Action;
import com.deezboiz.blackjack.engine.Card;
import com.deezboiz.blackjack.engine.Hand;

public class BasicStrategy extends Strategy {

    public BasicStrategy(int numDecks) {
        super(numDecks);
    }

    @Override
    public Action getAction(Hand hand, Card dealerUpCard) {
        if (hand.isSplittable() && BasicStrategyTables.splitTable.get(hand.getCard(0)).get(dealerUpCard)) {
            return Action.SPLIT;
        }
        if (hand.isSoft()) {
            return BasicStrategyTables.softTable.get(hand.getLowestValue() - 1).get(dealerUpCard);
        }
        return BasicStrategyTables.hardTable.get(hand.getHighestPlayableValue()).get(dealerUpCard);
    }
}
