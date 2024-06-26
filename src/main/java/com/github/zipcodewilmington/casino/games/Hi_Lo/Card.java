package com.github.zipcodewilmington.casino.games.Hi_Lo;

public class Card {

    public final static int SPADES = 0;   // Codes for the 4 suits.
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;

    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    public final static int ACE = 14;

    private final int suit;
    private final int value;

    public Card(int value, int suit) {
        if (suit != SPADES && suit != HEARTS && suit != DIAMONDS && suit != CLUBS)
            throw new IllegalArgumentException("Illegal playing card suit");
        if (value < 2 || value > ACE)
            throw new IllegalArgumentException("Illegal playing card value");
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuitAsString() {
        switch (suit) {
            case SPADES:   return "Spades";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
//            case CLUBS:    return "Clubs";
            default:       return "Clubs";
        }
    }

    public String getValueAsString() {
        switch (value) {
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case JACK:  return "Jack";
            case QUEEN: return "Queen";
            case KING:  return "King";
//            case ACE:   return "Ace";
            default:    return "ACE";
        }
    }

    @Override
    public String toString() {
        return getValueAsString() + " of " + getSuitAsString();
    }
}