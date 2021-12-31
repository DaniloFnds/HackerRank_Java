package patternSyntaxChecker;

import java.io.StringBufferInputStream;
import java.util.Scanner;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new StringBufferInputStream("3\n" +
                "([A-Z])(.+)\n" +
                "[AZ[a-z](a-z)\n" +
                "batcatpat(nat"));
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0 && in.hasNextLine()) {
            String pattern = in.nextLine();
            //Write your code
            try {
                final Pattern compile = Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}



