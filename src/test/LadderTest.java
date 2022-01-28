import com.inf5153.game.Ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    Ladder test_correct_1 = new Ladder(18, 100);
    Ladder test_correct_2 = new Ladder(1, 11);
    Ladder test_correct_3 = new Ladder(2, 52);
    Ladder test_correct_4 = new Ladder(10, 47);
    Ladder test_correct_5 = new Ladder(10, 90);


    @Test
    void constructor() {

        assertDoesNotThrow(() -> new Ladder(18, 100));
        assertDoesNotThrow(() -> new Ladder(1, 11));
        assertDoesNotThrow(() -> new Ladder(2, 52));
        assertDoesNotThrow(() -> new Ladder(10, 47));

        assertThrows(IllegalArgumentException.class,
                ()->{
                    Ladder test_incorrect_1 = new Ladder(200, 100);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Ladder test_incorrect_2 = new Ladder(80, 12);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Ladder test_incorrect_3 = new Ladder(60, 50);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Ladder test_incorrect_4 = new Ladder(82, 47);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Ladder test_incorrect_5 = new Ladder(91, 90);
                });

    }

    @Test
    void getStart() {

        assertEquals(18,test_correct_1.getStart());
        assertEquals(1,test_correct_2.getStart());
        assertEquals(2,test_correct_3.getStart());
        assertEquals(10,test_correct_4.getStart());
        assertEquals(10,test_correct_5.getStart());

    }

    @Test
    void getValue() {

        assertEquals(100,test_correct_1.getValue());
        assertEquals(11,test_correct_2.getValue());
        assertEquals(52,test_correct_3.getValue());
        assertEquals(47,test_correct_4.getValue());
        assertEquals(90,test_correct_5.getValue());

    }

    @Test
    void compareTo() {

        Ladder test_compare_1 = new Ladder(100, 180);
        Ladder test_compare_2  = new Ladder(12, 100);
        Ladder test_compare_3 = new Ladder(2, 200);
        Ladder test_compare_4  = new Ladder(5, 100);
        Ladder test_compare_5  = new Ladder(0, 100);

        assertEquals(82,test_compare_1.compareTo(test_correct_1));
        assertEquals(11,test_compare_2.compareTo(test_correct_2));
        assertEquals(0,test_compare_3.compareTo(test_correct_3));
        assertEquals(-5,test_compare_4.compareTo(test_correct_4));
        assertEquals(-10,test_compare_5.compareTo(test_correct_5));


    }
}