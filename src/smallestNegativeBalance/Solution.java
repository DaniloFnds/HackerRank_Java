package smallestNegativeBalance;

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
     * Complete the 'smallestNegativeBalance' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY debts as parameter.
     */

    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        // Write your code here

        Map<String, List<Map<String, Integer>>> mapa = new HashMap<>();
        for (List<String> linha : debts) {
            final String borrower = linha.get(0);
            final String lender = linha.get(1);
            final Integer amount = Integer.parseInt(linha.get(2));

            if (mapa.containsKey(borrower)) {
                final List<Map<String, Integer>> listaEmprestimos = mapa.get(borrower);
                final Optional<Map<String, Integer>> optLender = listaEmprestimos.stream().filter(mp -> mp.containsKey(lender)).findFirst();
                if (optLender.isPresent()) {
                    final Map<String, Integer> emprestimos = optLender.get();
                    final Integer valorEMprestado = emprestimos.get(lender);
                    emprestimos.replace(lender, valorEMprestado + amount);
                } else {
                    Map<String, Integer> novoEmprestimo = new HashMap<>();
                    novoEmprestimo.put(lender, amount);
                    listaEmprestimos.add(novoEmprestimo);
                }
            } else {
                final Map<String, Integer> novoEmprestimo = new HashMap<>();
                novoEmprestimo.put(lender, amount);
                List<Map<String, Integer>> listaEmprestimos = new ArrayList<>();
                listaEmprestimos.add(novoEmprestimo);
                mapa.put(borrower, listaEmprestimos);
            }
        }

        Map<String, Integer> mapaResultado = new HashMap<>();
        for (Map.Entry<String, List<Map<String, Integer>>> entry : mapa.entrySet()) {
            final String alex = entry.getKey();
            final List<Map<String, Integer>> listaEmprestimos = entry.getValue();
            for (Map<String, Integer> emprestimo : listaEmprestimos) {
                for (Map.Entry<String, Integer> paraQmEmprestei : emprestimo.entrySet()) {
                    for (Map.Entry<String, List<Map<String, Integer>>> todosEmprestimo : mapa.entrySet()) {
                        if (paraQmEmprestei.getKey().equals(todosEmprestimo.getKey())) {
                            final List<Map<String, Integer>> emprestimosDeQmEmprestou = todosEmprestimo.getValue();
                            for (Map<String, Integer> emprestimoRealizado : emprestimosDeQmEmprestou) {
                                if (emprestimoRealizado.containsKey(alex)) {
                                    final Integer blakeParaAlex = emprestimoRealizado.get(alex);
                                    final Integer value = paraQmEmprestei.getValue();
                                    mapaResultado.put(alex, blakeParaAlex - value);
                                } else {
                                    mapaResultado.put(alex, paraQmEmprestei.getValue() * -1);
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
            }
        }
        return mapaResultado.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("5\n" +
                "3\n" +
                "Alex Blake 5\n" +
                "Blake Alex 3\n" +
                "Casey Alex 7\n" +
                "Casey Alex 4\n" +
                "Casey Alex 2")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int debtsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int debtsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> debts = new ArrayList<>();

        IntStream.range(0, debtsRows).forEach(i -> {
            try {
                debts.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> result = Result.smallestNegativeBalance(debts);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
