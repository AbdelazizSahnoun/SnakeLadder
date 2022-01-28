import com.inf5153.game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    String[] nom_joueurs={"Premier","Deuxième","Troisième","Quatrième"};

    Player test_1=new Player(nom_joueurs[0],1);
    Player test_2=new Player(nom_joueurs[1],4);
    Player test_3=new Player(nom_joueurs[2],60);
    Player test_4=new Player(nom_joueurs[3],100);


    @Test
    void getName() {

        assertEquals(nom_joueurs[0],test_1.getName());
        assertEquals(nom_joueurs[1],test_2.getName());
        assertEquals(nom_joueurs[2],test_3.getName());
        assertEquals(nom_joueurs[3],test_4.getName());
    }

    @Test
    void positionTest() {

        test_1.setPosition(10);
        test_2.setPosition(30);
        test_3.setPosition(50);
        test_4.setPosition(2);

        assertEquals(10,test_1.getPosition());
        assertEquals(30,test_2.getPosition());
        assertEquals(50,test_3.getPosition());
        assertEquals(2,test_4.getPosition());

    }


}