import com.inf5153.game.Snake;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {

    Snake test_correct_1 = new Snake(100, 18);
    Snake test_correct_2 = new Snake(11, 1);
    Snake test_correct_3 = new Snake(52, 2);
    Snake test_correct_4 = new Snake(47, 10);
    Snake test_correct_5 = new Snake(90, 10);


    @Test
    void constructor() {

        assertDoesNotThrow(() -> new Snake(100,0));
        assertDoesNotThrow(() -> new Snake(11,1));
        assertDoesNotThrow(() -> new Snake(52,2));
        assertDoesNotThrow(() -> new Snake(47,30));

        assertThrows(IllegalArgumentException.class,
                ()->{
                    Snake test_incorrect_1 = new Snake(100, 200);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Snake test_incorrect_2 = new Snake(12, 80);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Snake test_incorrect_3 = new Snake(50, 60);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Snake test_incorrect_4 = new Snake(47, 82);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Snake test_incorrect_5 = new Snake(90, 91);
                });

    }

    @Test
    void getStart() {

        assertEquals(100,test_correct_1.getStart());
        assertEquals(11,test_correct_2.getStart());
        assertEquals(52,test_correct_3.getStart());
        assertEquals(47,test_correct_4.getStart());
        assertEquals(90,test_correct_5.getStart());

    }

    @Test
    void getValue() {

        assertEquals(18,test_correct_1.getValue());
        assertEquals(1,test_correct_2.getValue());
        assertEquals(2,test_correct_3.getValue());
        assertEquals(10,test_correct_4.getValue());
        assertEquals(10,test_correct_5.getValue());

    }

    @Test
    void compareTo() {

        Snake test_compare_1 = new Snake(100, 18);
        Snake test_compare_2  = new Snake(12, 1);
        Snake test_compare_3 = new Snake(51, 2);
        Snake test_compare_4  = new Snake(57, 10);
        Snake test_compare_5  = new Snake(80, 10);

        assertEquals(0,test_compare_1.compareTo(test_correct_1));
        assertEquals(1,test_compare_2.compareTo(test_correct_2));
        assertEquals(-1,test_compare_3.compareTo(test_correct_3));
        assertEquals(10,test_compare_4.compareTo(test_correct_4));
        assertEquals(-10,test_compare_5.compareTo(test_correct_5));


    }
}