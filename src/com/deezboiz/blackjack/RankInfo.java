package com.deezboiz.blackjack;

public class RankInfo {

    private String name;
    private int[] values;

    public RankInfo(String name, int[] values) {
        this.name = name;
        this.values = values;
    }


    public String getName() {
        return name;
    }

    public int[] getValues() {
        return values;
    }
}
