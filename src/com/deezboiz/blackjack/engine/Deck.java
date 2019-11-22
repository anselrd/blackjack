package com.deezboiz.blackjack.engine;

import java.util.Stack;

import static java.lang.Math.max;
import static java.util.Collections.shuffle;

public class Deck {

    private Stack<Card> cards = new Stack<>();
    private static int absoluteMinCards = 26;
    private static double shuffleFrac = 0.25;
    private int minCards;
    private int numDecks = 1;

    public Deck() {
        minCards = absoluteMinCards;
        createNewDeck();
    }

    Deck(int numDecks) {
        this.numDecks = numDecks;
        minCards = max((int) shuffleFrac * cards.size(), absoluteMinCards);
        createNewDeck();
    }

    private void createNewDeck() {
        for (int i = 0; i < numDecks; i++) {
            cards.addAll(generateStandardDeck());
        }
        shuffleCards();
    }

    private Stack<Card> generateStandardDeck() {
        Stack<Card> sd = new Stack<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(suit, new Rank(i));
                sd.add(card);
            }
        }
        return sd;
    }

    Card deal() {
        return cards.pop();
    }

    private void shuffleCards() {
        shuffle(cards);
    }

    void decideToShuffle() {
        if (cards.size() < minCards) {
            cards.clear();
            createNewDeck();
        }
    }

    void stackTheDeck() {
        cards.clear();
        for (int i = 0; i < 52; i++ ) cards.add(new Card(Card.Suit.SPADES, new Rank(1)));
    }
}
