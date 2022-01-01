package java2DArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("1 1 1 0 0 0\n" +
                "0 1 0 0 0 0\n" +
                "1 1 1 0 0 0\n" +
                "0 0 2 4 4 0\n" +
                "0 0 0 2 0 0\n" +
                "0 0 1 2 4 0")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            final List<Integer> linha = arr.get(i);
            for (int j = 0; j < 3; j++) {
                final Integer cell = linha.get(j);
                if (!cell.equals(0)) {
                    sum += cell;
                }
            }
        }


        System.out.println();
    }
}
