package com.deezboiz.blackjack;

public class FaceCard extends SingleValuedRank {

    private String name;

    public FaceCard(String name) {
        this.value = 10;
        this.name = name;
    }

}
