package javatutorial;
import java.util.Arrays;
/**
 * Created by Shawn on 2/17/16.
 */
public class LessonThirteen {
    public static void main(String[] args)
    {
        String randomString = "I'm just a randomstring";
        String gotToQuote = "He said, \"I'm here\"";


        System.out.println(randomString + " " + gotToQuote);

        String uppercaseStr = "BIG";
        String lowercaseStr = "big";

        if(uppercaseStr.equals(lowercaseStr))
        {
            System.out.println("They're equal");
        }// They are not becuase equals method cares about case
         // If you want to ignore case, using equalsIgnoreCase


        String letters = "abcde";
        String moreLetters = "fghijk";

        System.out.println("2nd char:" + letters.charAt(1));

        System.out.println(letters.compareTo(moreLetters));

        System.out.println(letters.contains("abc"));
        System.out.println(letters.endsWith("de"));

        System.out.println(letters.indexOf("cd"));

        // You can also specify the index to start searching from
        // indexof(StringToLookFor, IndexStartPosition)

        //lastIndexOf() works like indexof except it starts from the
        //end of the String you are searching

        //Count the length of a string
        System.out.println("Length of string letter: " + letters.length());

        //Replace a part of a string with sth else.
        System.out.println(letters.replace("abc","xy"));


        String[] letterArray = letters.split("");
        System.out.println(Arrays.toString(letterArray));

        char[] charArray = letters.toCharArray();
        System.out.println(Arrays.toString(charArray));

        //print certain range of letters
        System.out.println(letters.substring(2,4));

        System.out.println(letters.toUpperCase());

        String randString = "       dahfjkadl     ";
        System.out.println(randString.trim());

        //String Builder
        StringBuilder randSB = new StringBuilder("A random value");
        System.out.println(randSB.append("  again"));
        System.out.println(randSB);
        // delete a string from a starting index to a ending index
        System.out.println(randSB.delete(15,21));
        //find out the space I have in memory
        System.out.println(randSB.capacity());
        //To change your memory, we can use, arrayName.ensureCapacity(size you want);

        System.out.println(randSB.length());
        // To change the size of memory equals to the length of the string
        randSB.trimToSize();
        // To insert sth to the String in the string builder
        System.out.println(randSB.insert(1, "nother"));

        String oldSB = randSB.toString();

    }
}
