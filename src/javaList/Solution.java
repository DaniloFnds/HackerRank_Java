package javaList;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) {
        try {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(sc.readLine()); //query
            List<Integer> l = Stream.of(sc.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
            int query = Integer.parseInt(sc.readLine());

            for (int i = 0; i < query; i++) {
                String tipoModificao = sc.readLine();
                Map<Integer, Integer> mapInsert = new HashMap<>();
                List<Integer> insertQuery = null;
                int indexDeletar = 0;
                boolean hasDelete = false;
                if (tipoModificao.equals("Insert")) {
                    insertQuery = Stream.of(sc.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());

                    for (int i1 = 0; i1 < insertQuery.size() - 1; i1++) {
                        l.add(insertQuery.get(0), insertQuery.get(1));
                    }
                }
                if (tipoModificao.equals("Delete")) {
                    indexDeletar = Integer.parseInt(sc.readLine());
                    hasDelete = true;
                    l.remove(indexDeletar);

                }
            }

            final StringBuilder sb = new StringBuilder();
            l.forEach(v -> sb.append(v).append(" "));
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}