package com.deezboiz.blackjack;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main program starting...");

        Card booty = new Card(new Spades(), new Rank(1));
        System.out.println(booty.getRank());

    }

}
