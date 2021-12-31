package javaPrimalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("13"));

        String n = bufferedReader.readLine();

        final boolean probablePrime = new BigInteger(n).isProbablePrime(1);
       if(probablePrime) {
           System.out.println("prime");
       }else {
           System.out.println("not prime");
       }

        bufferedReader.close();
    }
}
