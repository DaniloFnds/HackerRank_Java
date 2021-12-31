package alternatingCharacters;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
        // Write your code here
        final int len = s.length();
        final char[] chars = s.toCharArray();
        int removido = 0;
        int i = 0;
        while (i < len) {
            if (i+1 != len && chars[i] == chars[i + 1]) {
                removido++;
            }
            i++;
        }

        return removido;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/input12.txt"))));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("5\n" +
                "AAAA\n" +
                "BBBBB\n" +
                "ABABABAB\n" +
                "BABABA\n" +
                "AAABBB")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.alternatingCharacters(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
