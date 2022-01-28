package com.inf5153.game;

public class Snake implements Case, Comparable<Snake> {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }


    public int getValue() {
        return end;
    }

    public Snake(int start, int end) {

        if(end>start){
            throw new IllegalArgumentException("Le snake doit avoir un fin inférieure au départ");
        }

        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Snake o) {

        return start - o.start;
    }
}
