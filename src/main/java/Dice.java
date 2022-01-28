package com.inf5153.game;

import java.util.Random;

public class Dice {

    private int max;
    private int valeur_actuelle;

    public Dice(int max) {
        this.max = max;
    }

    public int getValeur_actuelle() {
        return valeur_actuelle;
    }

    public void rollDice() {
        int n;
        Random r = new Random();
        n = r.nextInt(max + 1);
        valeur_actuelle = (n == 0 ? 1 : n);
    }

}
