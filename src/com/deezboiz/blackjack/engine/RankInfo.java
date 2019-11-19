package com.deezboiz.blackjack.engine;

public class RankInfo {

    private String name;
    private int[] values;
    private String symbol;

    public RankInfo(String name, int[] values, String symbol) {
        this.name = name;
        this.values = values;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public int[] getValues() {
        return values;
    }

    public String getSymbol() { return symbol; }
}
