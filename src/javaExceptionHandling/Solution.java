package javaExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        
        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a / b);
        }catch(Exception e) {
            if(e instanceof InputMismatchException) {
                System.out.println("java.util.InputMismatchException");
            }else {
                System.out.println(e);
            }

        }
    }
}