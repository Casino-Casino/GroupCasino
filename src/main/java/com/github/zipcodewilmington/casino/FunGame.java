package com.github.zipcodewilmington.casino;


import java.util.List;

public abstract class FunGame {
    private boolean isOver;
    private final List<Object> players;

    protected FunGame(List<Object> players) {
        this.players = players;
    }
}
