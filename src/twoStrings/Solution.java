package twoStrings;

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
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // Write your code here

        Map<Character, Integer> mapaS1 = new HashMap<>();
        Map<Character, Integer> mapaS2 = new HashMap<>();

        final char[] s1Arr = s1.toCharArray();
        final char[] s2Arr = s2.toCharArray();

        for (int i = 0; i < s1Arr.length; i++) {
            mapaS1.put(s1Arr[i], mapaS1.containsKey(s1Arr[i]) ? mapaS1.get(s1Arr[i]) + 1 : 1);
        }

        for (int i = 0; i < s2Arr.length; i++) {
            mapaS2.put(s2Arr[i], mapaS2.containsKey(s2Arr[i]) ? mapaS2.get(s2Arr[i]) + 1 : 1);
        }

        String result = "YES";
        for (Character s_1 : mapaS2.keySet()) {
            if (!mapaS1.containsKey(s_1)) {
                System.out.println();
                result = "NO";
            } else {
                result = "YES";
                break;
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("2\n" +
                "aardvark\n" +
                "apple\n" +
                "beetroot\n" +
                "sandals")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
