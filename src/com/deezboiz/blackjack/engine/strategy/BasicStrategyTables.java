package com.deezboiz.blackjack.engine.strategy;

import com.deezboiz.blackjack.engine.Card;
import com.deezboiz.blackjack.engine.Rank;

import java.util.HashMap;
import java.util.Map;

public class BasicStrategyTables {

    public static HashMap<Card, HashMap<Card, Boolean>> splitTable = new HashMap<>();
    static {
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(2)), true)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(3)), true)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(4)), true)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(7)), true)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(2)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(2)), true)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(3)), true)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(4)), true)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(7)), true)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(3)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(2)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(3)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(4)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(7)), true)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(4)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(2)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(3)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(4)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(5)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(6)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(7)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(5)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(2)), true)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(3)), true)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(4)), true)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(7)), false)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(6)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(2)), true)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(3)), true)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(4)), true)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(7)), true)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(7)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(2)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(3)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(4)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(7)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(8)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(9)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(10)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(11)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(12)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(13)), true)));
        splitTable.put(new Card(null, new Rank(8)), new HashMap<>(Map.of(new Card(null, new Rank(1)), true)));

        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(2)), true)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(3)), true)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(4)), true)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(7)), false)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(8)), true)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(9)), true)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(9)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(2)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(3)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(4)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(5)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(6)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(7)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(10)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(2)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(3)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(4)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(5)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(6)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(7)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(11)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(2)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(3)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(4)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(5)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(6)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(7)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(12)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(2)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(3)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(4)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(5)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(6)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(7)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(8)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
        splitTable.put(new Card(null, new Rank(13)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(2)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(3)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(4)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(7)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(8)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(9)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(10)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(11)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(12)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(13)), true)));
        splitTable.put(new Card(null, new Rank(1)), new HashMap<>(Map.of(new Card(null, new Rank(1)), true)));
    }

//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(2)), true)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(3)), true)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(4)), true)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(5)), true)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(6)), true)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(7)), true)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(8)), true)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(9)), false)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(10)), false)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(11)), false)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(12)), false)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(13)), false)));
//        splitTable.put(new Card(null, new Rank(0)), new HashMap<>(Map.of(new Card(null, new Rank(1)), false)));

}
