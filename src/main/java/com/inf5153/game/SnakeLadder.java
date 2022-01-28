package com.inf5153.game;

import java.util.*;

public class SnakeLadder {


    Player[] joueurs;
    Board board;
    Dice des;

    public SnakeLadder(int nb_joueurs,String[] nom_joueurs,int board_max,int dice_max) {
        joueurs=new Player[nb_joueurs];

        for(int i=0;i<nb_joueurs;i++){
            joueurs[i]=new Player(nom_joueurs[i],1);
        }

        board=new Board(board_max);

        des=new Dice(dice_max);

    }


    public void addSnake(int start,int end){board.addSnake(start,end);
    }

    public void addLadder(int start,int end){
        board.addLadder(start,end);
    }



    public void startGame(){

        board.generateBoard();

        Scanner s = new Scanner(System.in);
        String str;
        boolean winner=false;


        System.out.println("\n\nLE TOUR DU " + joueurs[0].getName().toUpperCase() + " JOUEUR");
        System.out.println("Appuyer du \"l\" pour lancer les dés");
        str = s.next();
        des.rollDice();
        int i=0;
        int tours=0;

        do {


            joueurs[tours].setPosition(board.move(joueurs[tours].getPosition(),des.getValeur_actuelle()));
            for(int j=0;j<joueurs.length;j++) {
                System.out.println(joueurs[j].getName() + " joueur"  + " :: " + joueurs[j].getPosition());
            }

            System.out.println("------------------");

            if(joueurs[tours].getPosition()== board.getBoard_size()){

                System.out.println("Le " + joueurs[tours].getName()+ " joueur gagne!");
                winner=true;
            }else {

                i++;
                tours = i % joueurs.length;
                System.out.println("\n\nLE TOUR DU " + joueurs[tours].getName().toUpperCase()+ " JOUEUR");
                str = s.next();
                des.rollDice();
            }

        }while ("l".equals(str) && !winner);


    }

}

