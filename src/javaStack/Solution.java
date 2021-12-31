package javaStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Solution {

    private static final Deque<Character> sQueue = new ArrayDeque<>();

    public static void main(String[] argh) {
        Scanner sc = new Scanner(new StringBufferInputStream("{}()\n" +
                "({()})\n" +
                "{}(\n" +
                "[]"));

        Map<Character, Character> pares = new HashMap<>();
        final Deque<Character> stack = new ArrayDeque<>();

        pares.put('{', '}');
        pares.put('(', ')');
        pares.put('[', ']');
        while (sc.hasNext()) {
            String input = sc.next();
            if(isBalanced(input)) {
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }
    private static boolean isBalanced(String str) {

        sQueue.clear();
        int len = str.length();
        boolean failed = false;
        for (int ix = 0; !failed && ix < len; ++ix) {
            char currChar = str.charAt(ix);
            switch (currChar) {
                case '(':
                case '[':
                case '{':
                    sQueue.addFirst(currChar);
                    break;
                case ']':
                    failed = sQueue.size() == 0 || (sQueue.removeFirst() != '[');
                    break;
                case ')':
                    failed = sQueue.size() == 0 || (sQueue.removeFirst() != '(');
                    break;
                case '}':
                    failed = sQueue.size() == 0 || (sQueue.removeFirst() != '{');
                    break;
                default:
                    failed = true;
                    break;
            }
        }
        failed |= (sQueue.size() != 0);
        return !failed;
    }
}




