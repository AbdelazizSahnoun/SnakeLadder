import com.inf5153.game.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board test_1=new Board(20);
    Board test_2=new Board(50);
    Board test_3=new Board(100);


    ByteArrayOutputStream out_contenu = new ByteArrayOutputStream();
    PrintStream test_correct_out = System.out;

    @BeforeEach
    public void activeStreams() {
        System.setOut(new PrintStream(out_contenu));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(test_correct_out);
    }


    @Test
    void getBoard_max() {

        assertEquals(20,test_1.getBoard_size());
        assertEquals(50,test_2.getBoard_size());
        assertEquals(100,test_3.getBoard_size());

    }

    @Test
    void addSnake() {

        assertDoesNotThrow(() -> test_1.addSnake(2,1));
        assertDoesNotThrow(() -> test_1.addSnake(18,16));

        assertDoesNotThrow(() -> test_2.addSnake(40,2));
        assertDoesNotThrow(() -> test_2.addSnake(49,1));

        assertDoesNotThrow(() -> test_3.addSnake(32,11));
        assertDoesNotThrow(() -> test_3.addSnake(87,11));

        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_1.addSnake(20,1);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_2.addSnake(50,1);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_3.addSnake(100,1);
                });

        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_1.addSnake(1,1);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_2.addSnake(1,1);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_3.addSnake(1,1);
                });

        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_1.addSnake(-1,1);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_2.addSnake(20,-1);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_3.addSnake(200,2);
                });


    }

    @Test
    void addLadder() {

        assertDoesNotThrow(() -> test_1.addLadder(2,3));
        assertDoesNotThrow(() -> test_1.addLadder(16,18));

        assertDoesNotThrow(() -> test_2.addLadder(2,40));
        assertDoesNotThrow(() -> test_2.addLadder(2,49));

        assertDoesNotThrow(() -> test_3.addLadder(11,32));
        assertDoesNotThrow(() -> test_3.addLadder(11,87));

        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_1.addLadder(12,20);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_2.addLadder(12,50);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_3.addLadder(12,100);
                });

        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_1.addLadder(1,19);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_2.addLadder(1,39);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_3.addLadder(1,49);
                });

        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_1.addLadder(21,32);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_2.addLadder(-5,39);
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    test_3.addLadder(-59,-49);
                });




    }

    @Test
    void generateBoard() {

        test_1.addSnake(2,1);
        test_1.addSnake(18,16);
        test_1.addLadder(3,6);
        test_1.addLadder(16,18);

        test_2.addSnake(40,2);
        test_2.addSnake(49,1);
        test_2.addLadder(2,40);
        test_2.addLadder(10,49);

        test_3.addSnake(32,11);
        test_3.addSnake(87,11);
        test_3.addLadder(11,32);
        test_3.addLadder(14,87);

        test_1.generateBoard();
        test_2.generateBoard();
        test_3.generateBoard();

        test_1.move(1,1);
        assertEquals("swallowed by snake\n",out_contenu.toString());
        out_contenu.reset();
        test_1.move(16,2);
        assertEquals("swallowed by snake\n",out_contenu.toString());
        out_contenu.reset();
        test_1.move(1,2);
        assertEquals("climb up the ladder\n",out_contenu.toString());
        out_contenu.reset();
        test_1.move(13,3);
        assertEquals("climb up the ladder\n",out_contenu.toString());
        out_contenu.reset();


        test_2.move(39,1);
        assertEquals("swallowed by snake\n",out_contenu.toString());
        out_contenu.reset();
        test_2.move(40,9);
        assertEquals("swallowed by snake\n",out_contenu.toString());
        out_contenu.reset();
        test_2.move(1,1);
        assertEquals("climb up the ladder\n",out_contenu.toString());
        out_contenu.reset();
        test_2.move(1,9);
        assertEquals("climb up the ladder\n",out_contenu.toString());
        out_contenu.reset();


        test_3.move(30,2);
        assertEquals("swallowed by snake\n",out_contenu.toString());
        out_contenu.reset();
        test_3.move(40,47);
        assertEquals("swallowed by snake\n",out_contenu.toString());
        out_contenu.reset();
        test_3.move(1,10);
        assertEquals("climb up the ladder\n",out_contenu.toString());
        out_contenu.reset();
        test_3.move(1,13);
        assertEquals("climb up the ladder\n",out_contenu.toString());
        out_contenu.reset();



    }

    @Test
    void move() {

        test_1.addSnake(2,1);
        test_1.addSnake(18,16);
        test_1.addLadder(3,6);
        test_1.addLadder(16,18);

        test_2.addSnake(40,2);
        test_2.addSnake(49,1);
        test_2.addLadder(2,40);
        test_2.addLadder(10,49);

        test_3.addSnake(32,11);
        test_3.addSnake(87,11);
        test_3.addLadder(11,32);
        test_3.addLadder(14,87);

        test_1.generateBoard();
        test_2.generateBoard();
        test_3.generateBoard();


        assertEquals(1,test_1.move(1,1));
        assertEquals(16,test_1.move(16,2));
        assertEquals(6,test_1.move(1,2));
        assertEquals(18,test_1.move(15,1));
        assertEquals(11,test_1.move(10,1));
        assertEquals(15,test_1.move(10,5));

        assertEquals(2,test_2.move(39,1));
        assertEquals(1,test_2.move(40,9));
        assertEquals(40,test_2.move(1,1));
        assertEquals(49,test_2.move(9,1));
        assertEquals(18,test_2.move(10,8));
        assertEquals(30,test_2.move(24,6));

        assertEquals(11,test_3.move(30,2));
        assertEquals(11,test_3.move(40,47));
        assertEquals(32,test_3.move(10,1));
        assertEquals(87,test_3.move(13,1));
        assertEquals(28,test_3.move(20,8));
        assertEquals(56,test_3.move(50,6));




    }
}