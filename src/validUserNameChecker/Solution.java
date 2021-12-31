package validUserNameChecker;

import java.io.StringReader;
import java.util.Scanner;
class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "^([A-Za-z])(?=.*\\d)(?=.*[_])[A-Za-z\\d_]{7,30}$|^([A-Za-z])[A-Za-z]{7,30}$|^([A-Za-z])[A-Za-z\\d[_]]{7,30}$";
}


public class Solution {
    private static final Scanner scan = new Scanner(new StringReader("4\n" +
            "abcabca\n" +
            "abaabcaa\n" +
            "a_aaaaaa\n" +
            "a_aaaaa"));
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}