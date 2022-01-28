package com.inf5153.game;

import java.util.*;

public class Board {

    public int getBoard_size() {
        return board_size;
    }

    private int board_size;
    private List<Case> cases = new ArrayList<>();
    private SortedSet<Snake> snakes = new TreeSet<>();
    private SortedSet<Ladder> ladders = new TreeSet<>();


    public void addSnake(int start, int end) {

        if((start<0||end<0)||(start>board_size||end>board_size)){
            throw new IllegalArgumentException("addSnake : paramètres invalide");
        }else if( start==board_size || start==1 || end==board_size){
            throw new IllegalArgumentException("Le snake ne doit pas se trouver sur la case finale ou la case initiale du board");
        }
        Snake snake = new Snake(start, end);
        snakes.add(snake);
    }

    public void addLadder(int start, int end) {
        if(  (start<0||end<0) ||  (start>board_size||end>board_size)){
            throw new IllegalArgumentException("addLadder : paramètres invalide");
        }else if( start==board_size || start==1 || end==board_size){
            throw new IllegalArgumentException("Le ladder ne doit pas se trouver sur la case finale ou la case initiale du board");
        }
        Ladder ladder = new Ladder(start, end);
        ladders.add(ladder);
    }


    public Board(int board_size) {
        this.board_size = board_size;
    }



    public void generateBoard() {

        Iterator<Snake> it_snake = snakes.iterator();
        Iterator<Ladder> it_ladder = ladders.iterator();

        Snake precedant_snake = it_snake.next();
        Ladder precedant_ladder = it_ladder.next();

        for (int i = 1; i <= board_size; i++) {

            if (precedant_snake.getStart() == i) {
                cases.add(precedant_snake);

                if (it_snake.hasNext())
                    precedant_snake = it_snake.next();

            } else if (precedant_ladder.getStart() == i) {
                cases.add(precedant_ladder);

                if (it_ladder.hasNext())
                    precedant_ladder = it_ladder.next();

            } else {
                cases.add(new Cellule(i));
            }

        }

    }

    public int move(int position, int dice_value) {

        position--;

        int returnValue;
        if (position + dice_value > board_size - 1) {
            returnValue = board_size - (dice_value - (board_size - position));
        } else {
            returnValue = cases.get(position + dice_value).getValue();

            if (cases.get(position + dice_value).getClass().getSimpleName().equals("Snake")) {
                System.out.println("swallowed by snake");
            } else if (cases.get(position + dice_value).getClass().getSimpleName().equals("Ladder")) {
                System.out.println("climb up the ladder");
            }

        }
        return returnValue;

    }
}
