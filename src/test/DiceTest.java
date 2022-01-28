import com.inf5153.game.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    Dice dice_1 = new Dice(6);
    Dice dice_2 = new Dice(4);
    Dice dice_3 = new Dice(8);
    Dice dice_4 = new Dice(10);


    @Test
    void dice() {
        dice_1.rollDice();
        int test_1 = dice_1.getValeur_actuelle();

        dice_2.rollDice();
        int test_2 = dice_2.getValeur_actuelle();

        dice_3.rollDice();
        int test_3 = dice_3.getValeur_actuelle();

        dice_4.rollDice();
        int test_4 = dice_4.getValeur_actuelle();


        assert(test_1>0 && test_1<=6);
        assert(test_2>0 && test_2<=4);
        assert(test_3>0 && test_3<=8);
        assert(test_4>0 && test_4<=10);

    }
}