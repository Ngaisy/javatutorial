package javatutorial;

import java.util.regex.*;

/**
 * Created by Shawn on 2/26/16.
 */
public class LessonNineteen {

    public static void main(String[] args) {
        String longString = " Derek Banas CA 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 ";
        String strangeString = " 1Z aaa **** *** {{{ {{ { ";

        /*
        [ ] Insert characters that are valid
        [^ ] Insert characters that are not valid
        \\s Any white space
        {n,m} Whatever proceeds must occur between n and m times
         */

        // Word must contain letters that are 2 to 20 characters in length
        // [A-Za-z]{2,20} Or \w{2,20}

        regexChecker("\\s[A-Za-z]{2,20}\\s", longString);
// -----------------------------------------------------------------------//
        /*
        \\d Any digits 0-9
        \\D Anything not a number
        {n} Whatever proceeds must occur n times
         */

        // Only 5 digits
        // \\s[0-9]{5}\\s or \\{5}
// -----------------------------------------------------------------------//

        /*
        | is used for OR clause situations
         */
// -----------------------------------------------------------------------//
        // Must start with a A or C, followed by 1 letter in brackets
        // Must be a maximun of 2 characters in length
        // A[KLRZ]|C[AOT]

        regexChecker("A[KLRZ]|C[AOT]", longString);
// -----------------------------------------------------------------------//
        /*
        {n,} Whatever proceeds must occur at least n times
        + Whatever proceeds must occur one or more times
        .^*+?{}[] \|() Characters that must be escaped or backslashed
         */
// -----------------------------------------------------------------------//
        // Grab any String that contains 1 or more

        regexChecker("(\\{{1,})", strangeString);
        //regexChecker("(\\{+)", strangeString);
// -----------------------------------------------------------------------//
        // Get 3 characters except newline
        // . Anything but newline

        regexChecker(".{3}", strangeString);
// -----------------------------------------------------------------------//
        /*
        \\w Anyword type character A-Z, a-z, 0-9, _
        \\W Any non word character
        * Occurs zero or more times
         */

        //regexChecker("\\w*", strangeString);
        regexChecker("[A-Za-z0-9._%-] + @[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", longString);
        // ? 0 or 1 of what proceeds it

        //regexChecker("([0-9]( | -)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3})( |-)?([0-9]{4}|[a-zA-Z0-9]{7})", longString);
regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?)( |-)?([0-9]{3})( |-)?([0-9]{4})",longString);
        regexReplace(longString);
    }

        public static void regexChecker(String theRegex, String str2Check) {


            // Define a regular expression using Pattern
            Pattern checkRegex = Pattern.compile(theRegex);

            // Creates a Matcher object that searches the String for
            // anything that matches the REGEX
            Matcher regexMatcher = checkRegex.matcher(str2Check);

            while (regexMatcher.find()) {
                if (regexMatcher.group().length() != 0) {
                    System.out.println(regexMatcher.group().trim());

                    // You can get the starting and ending indexes

                    System.out.println("Start Index: " + regexMatcher.start());
                    System.out.println("End Index: " + regexMatcher.end());

                }
            }
        }

        public static void regexReplace(String str2Replace){

            Pattern replace = Pattern.compile("\\s+");
            // Ignore case: Pattern replace = Pattern.compile("\\s+");

            //Matcher regexMatcher = replace.matcher(str2Replace);
            Matcher regexMatcher1 = replace.matcher(str2Replace.trim());
            //System.out.println(regexMatcher.replaceAll(", "));
            System.out.println(regexMatcher1.replaceAll(", "));
    }


}


