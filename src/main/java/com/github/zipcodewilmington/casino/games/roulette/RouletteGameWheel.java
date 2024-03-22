package com.github.zipcodewilmington.casino.games.roulette;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteGameWheel {
    private List<RouletteGamePocket> pockets;

    public RouletteGameWheel(){
        pockets = new ArrayList<>();
        //populate pockets with numbers and colors
        for(int i = 0; i <= 36; i++){
            String color = (i % 2 == 0) ? "black" : "red";
            pockets.add(new RouletteGamePocket(i,color));
        }
    }

    public RouletteGamePocket spin() {
        Random random = new Random();
        int index = random.nextInt(pockets.size());
        return pockets.get(index);
    }
}
