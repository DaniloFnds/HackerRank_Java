package tagContentExtractor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new StringReader("4\n" +
                "<h1>Nayeem loves counseling</h1>\n" +
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>\n" +
                "<Amee>safat codes like a ninja</amee>\n" +
                "<SA premium>Imtiaz has a secret crush</SA premium>"));
        List<String> results = new ArrayList<>();
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0 && in.hasNextLine()) {
            String line = in.nextLine();

            //Write your code here
            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if (!matchFound) {
                System.out.println("None");
            }
        }

        testCases--;

    }
}



