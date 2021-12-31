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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        Map<Character, Integer> copia = new HashMap<>(map);
        final Map<Integer, List<Integer>> group = map.values().stream().collect(Collectors.groupingBy(Function.identity()));


        if (group.size() > 2) {
            return "NO";
        }

        if(group.size() == 1) {
            return "YES";
        }

        for (Map.Entry<Integer, List<Integer>> entry : group.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> prox : group.entrySet()) {
                if(!entry.getKey().equals(prox.getKey()) && prox.getKey() - 1 == 0 && prox.getValue().size() == 1) {
                    return "YES";
                }
                if (!entry.getKey().equals(prox.getKey()) && entry.getKey() == prox.getKey() - 1 && prox.getValue().size() == 1) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("b")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
