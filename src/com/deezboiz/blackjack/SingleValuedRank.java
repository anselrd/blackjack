package com.deezboiz.blackjack;

public abstract class SingleValuedRank extends Rank {

    protected int value;

    public int[] getValueOptions(){
        return new int[] {this.value};
    }

}
