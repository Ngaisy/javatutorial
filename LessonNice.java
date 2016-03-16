package javatutorial;

import java.util.Arrays;
/**
 * Created by Shawn on 2/12/16.
 */
public class LessonNice {
    public static void main(String[] args)
    {
        int[] randomArray;

        int[] numberArray = new int[10];

        randomArray = new int[20];
        randomArray[1] = 2;
        String[] stringArray = {"just", "random", "words"};

        for(int i = 0;i < numberArray.length;i++)
        {
            numberArray[i] = i;
        }
        int k = 1;
        while(k <= 41){ System.out.print('-'); k++; }
        System.out.println();

        for(int j = 0; j<numberArray.length;j++)
        {
            System.out.print("|" + j + " ");
        }
        System.out.println("|");

        String[][] multiArray = new String[10][10];
        for (int i = 0; i < multiArray.length; i++)
        {
            for(int j = 0; j < multiArray[i].length; j++)
            {
                multiArray[i][j] = i + " " + j;
            }
        }

        k = 1;
        while(k<61){ System.out.print("-"); k++; }
        System.out.println();

        for (int i = 0; i < multiArray.length; i++)
        {
            for(int j = 0; j < multiArray[i].length; j++)
            {
                System.out.print("| " + multiArray[i][j] + " ");
            }
            System.out.println("|");
        }
        k = 1;
        while(k<61){ System.out.print("-"); k++; }
        System.out.println();

        for(String[] rows: multiArray)
        {
            for(String column : rows)
            {
                System.out.print("| " + column + " ");
            }
            System.out.println("|");
        }

        int[] numberCopy = Arrays.copyOf(numberArray,5);
        for(int num:numberCopy)
        {
            System.out.print(num);
        }
        System.out.println("\n");

        //Array.toString: Transfer Array into String format
        //Array.sort: Sort the elements in the Array
        //Array.fill(Array, 'sth') : fill array with sth
        //Array.binarySearch(Array.'sth'): Search in an array for 'sth', negative output means finding nothing
    }
}
