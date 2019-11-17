package com.deezboiz.blackjack;

public abstract class DoubleValuedRank extends Rank {

    protected int[] values;

    public int[] getValueOptions(){
        return this.values;
    }

}
