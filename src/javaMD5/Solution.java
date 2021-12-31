package javaMD5;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        final Scanner sc = new Scanner(System.in);
        final String password = sc.next();
        try {
            final MessageDigest md5 = MessageDigest.getInstance("SHA-256");
            md5.update(password.getBytes());
            final String s = DatatypeConverter.printHexBinary(md5.digest()).toLowerCase();
            System.out.println(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}