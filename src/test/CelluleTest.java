import com.inf5153.game.Cellule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CelluleTest {

    Cellule test_correct_1 = new Cellule(100);
    Cellule test_correct_2 = new Cellule(11);
    Cellule test_correct_3 = new Cellule(52);
    Cellule test_correct_4 = new Cellule(47);
    Cellule test_correct_5 = new Cellule(90);

    @Test
    void getValue() {

        assertEquals(100,test_correct_1.getValue());
        assertEquals(11,test_correct_2.getValue());
        assertEquals(52,test_correct_3.getValue());
        assertEquals(47,test_correct_4.getValue());
        assertEquals(90,test_correct_5.getValue());
    }


}