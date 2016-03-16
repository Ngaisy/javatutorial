package javatutorial;


/**
 * Created by Shawn on 2/11/16.
 */
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
public class LessonEight {
    public static void main(String[] args)
    {
       /* Monster Frank = new Monster();

        Frank.name = "Frank";
        //due to "attack" is an private object, so cannot be achieved by outside document
        //so I need special function, such getAttack.
        System.out.println(Frank.name + "has an attack of" + Frank.getAttack());
        */
        MonsterTwo.buildBattleBoard();

        char[][] tempBattleBoard = new char[10][10];

        MonsterTwo[] Monsters = new MonsterTwo[4];

        Monsters[0]  = new MonsterTwo(1000,20, 1,"Frank");
        Monsters[0]  = new MonsterTwo(500,40, 2,"Drac");
        Monsters[0]  = new MonsterTwo(1000,20, 1,"Paul");
        Monsters[0]  = new MonsterTwo(1000,20, 1,"George");

        MonsterTwo.redrawBoard();

    }
}

