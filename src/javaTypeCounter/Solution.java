package javaTypeCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;


class Result {

    /*
     * Complete the 'typeCounter' function below.
     *
     * The function accepts STRING sentence as parameter.
     */

    public static void typeCounter(String sentence) {

        final String[] s = sentence.split(" ");
        int countStr = 0;
        int countInt = 0;
        int countDouble = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].matches("[a-z]*")) {
                countStr++;
            }

            if (!s[i].contains(".") && s[i].matches("^\\d+$")) {
                countInt++;
                continue;
            }

            if (s[i].contains(".") && s[i].matches("[+-]?\\d*\\.?\\d+")) {
                countDouble++;
            }
        }
        System.out.println("strings " + countStr);
        System.out.println("integer " + countInt);
        System.out.println("double " + countDouble);
    }


}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("can you give me 10 bucks puff in 7.5 or 7")));

        String sentence = bufferedReader.readLine();

        Result.typeCounter(sentence);

        bufferedReader.close();
    }
}
