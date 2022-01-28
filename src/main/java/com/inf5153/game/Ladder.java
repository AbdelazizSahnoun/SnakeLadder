package com.inf5153.game;

public class Ladder implements Case, Comparable<Ladder> {

    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getValue() {
        return end;
    }

    public Ladder(int start, int end) {

        if(end<start){
            throw new IllegalArgumentException("Le ladder doit avoir une fin supérieure au départ");
        }

        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Ladder o) {
        return start - o.start;
    }

}
