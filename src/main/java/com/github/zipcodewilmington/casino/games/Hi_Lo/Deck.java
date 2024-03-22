package com.github.zipcodewilmington.casino.games.Hi_Lo;

import java.util.ArrayList;
import java.util.Collections;
public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
            for (int value = 2; value <= Card.ACE; value++) {
                cards.add(new Card(value, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            return null; // The deck is empty.
        }
        return cards.remove(cards.size() - 1);
    }


//    public int cardsLeft() {
//        return cards.size();
//    }
}