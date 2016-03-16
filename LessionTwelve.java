package javatutorial;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Shawn on 2/17/16.
 */
public class LessionTwelve {

    public static void main(String[] args){

        LinkedList lindedListOne = new LinkedList();
        LinkedList<String> names = new LinkedList<String>();

        names.add("A");
        names.add("B");

        names.addLast("C");

        names.addFirst("D");

        names.add(0,"E");

        names.set(2, "F");

        names.remove(4); // equal to names.remove("C");


        for(String name : names)
        {
            System.out.println(name);
        }

        System.out.println("\nFirst Index:" + names.get(0));

        System.out.println("\nFirst Index:" + names.getLast());

        LinkedList<String> nameCopy = new LinkedList<String>(names);
        System.out.println("\nnameCopy" + nameCopy);

        if(names.contains("C")){
            System.out.println("\nNoals Here");
        }

        if(names.containsAll(nameCopy))
        {
            System.out.println("\nCollections the Same");
        }

        System.out.println("\nD index at " + names.indexOf("D"));
        System.out.println("\nList Empty: " + names.isEmpty());
        System.out.println("\nHow many: " + names.size());
        System.out.println("\nLook without Error: " + names.peek());
        System.out.println("\nremove first element:" + nameCopy.poll());
        System.out.println("\nremove first element:" + nameCopy.pollLast());

        nameCopy.push("G");
        System.out.println("nameCopy includes: " +nameCopy);
        nameCopy.pop();
        System.out.println("nameCopy includes: " +nameCopy);

        Object[]nameArray = new Object[4];
        nameArray = names.toArray();
        System.out.println(Arrays.toString(nameArray));

        names.clear();
    }
}
