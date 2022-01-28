import com.inf5153.game.*;

public class Main {

    public static void main(String[] args) {
        /*
    	SnakesNLadders s = new SnakesNLadders();
        s.startGame();
         */



        String[] nom_joueurs={"Premier","Deuxième"};
        SnakeLadder game=new SnakeLadder(nom_joueurs.length,nom_joueurs,100,6);

        game.addSnake(99,54);
        game.addSnake(99,54);
        game.addSnake(70,55);
        game.addSnake(52,42);
        game.addSnake(25,2);
        game.addSnake(95,72);

        game.addLadder(6,25);
        game.addLadder(11,40);
        game.addLadder(60,85);
        game.addLadder(46,90);
        game.addLadder(17,69);

        game.startGame();

    }

}