package com.deezboiz.blackjack;

import java.util.List;
import java.util.Stack;

import static java.util.Collections.shuffle;

public class Deck {

    private List<Card> cards = new Stack<>();

    public Deck() {
        cards = generateStandardDeck();
        shuffleCards();
    }

    public Deck(int numDecks) {
        for (int i = 0; i < numDecks; i++) {
            cards.addAll(generateStandardDeck());
        }
        shuffleCards();
    }

    private List<Card> generateStandardDeck() {
        List<Card> sd = new Stack<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(suit, new Rank(i));
                sd.add(card);
            }
        }
        return sd;
    }

    public void shuffleCards() {
        shuffle(cards);
    }

}
