package sherlockAndAnagrams;

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
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here

        //precisa existir dados duplicados, senao retorna 0(zero)

        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }

        int count = 0;
        for (int i = 0; i < result.size(); i++) {
            final String current = result.get(i);
            final List<String> rest = result.subList(i + 1, result.size());


            for (int j = 0; j < rest.size(); j++) {
                final String string2 = rest.get(j);
                if (current.length() == string2.length()) {
                    Map<String, Integer> mapa = new HashMap<>();

                    for (int x = 0; x < current.length(); x++) {
                        final String g = String.valueOf(current.charAt(x));
                        if (mapa.containsKey(g)) {
                            mapa.replace(g, mapa.get(g) + 1);
                        } else {
                            mapa.put(g, 1);
                        }
                    }

                    System.out.println();
                }
                System.out.println();
            }
        }


        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("1\n" +
                "abcd")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

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
