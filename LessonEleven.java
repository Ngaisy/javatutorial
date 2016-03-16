package javatutorial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
/**
 * Created by Shawn on 2/17/16.
 */
public class LessonEleven {

    public static void main(String[] args)
    {
        ArrayList arrayListOne;

        arrayListOne = new ArrayList();

        ArrayList arrayListTwo = new ArrayList();

        ArrayList<String> names = new ArrayList<String>();

        names.add("A");
        names.add("B");
        names.add("C");

        names.add(2, "D");

        for(int i = 0; i < names.size(); i++)
        {
            System.out.println(names.get(i));
        }

        //Replace one element in an array
        names.set(0, "E");
        //Remove one element in an array
        names.remove(3);
        //Remove several elements in an array
        //names.removeRange(0,1);

        System.out.println(names);

        //enhanced for loop
        for(String i : names)
        {
            System.out.println(i);
        }
        System.out.println();

        Iterator indivItems = names.iterator();

        //if there is more item to print, hasNext() will deter it.
        // .next() will print it out.
        while(indivItems.hasNext())
        {
            System.out.println(indivItems.next());
        }

        ArrayList nameCopy = new ArrayList();
        ArrayList nameBackup = new ArrayList();

        nameCopy.addAll(names);
        System.out.println(nameCopy);


        //find a variable in an array
        String paulYoung = "Paul Young";

        names.add(paulYoung);

        //find variable in an array
        if(names.contains(paulYoung))
        {
            System.out.println("Paul is here");
        }

        if(names.containsAll(nameCopy))
        {
            System.out.println("Everything in nameCopy is in names");
        }

        // clean up all the variable in an array
        names.clear();

        // .isEmpty() check if an array is empty
        if(names.isEmpty())
        {
            System.out.println("The ArrayList is empty");
        }


        Object[] moreNames = new Object[4];
        // toArray converts the ArrayList into an array of objects
        moreNames = nameCopy.toArray();
        // toString converts items in the array into a String
        System.out.println(Arrays.toString(moreNames));

    }
}
