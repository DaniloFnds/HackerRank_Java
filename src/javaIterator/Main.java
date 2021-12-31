package javaIterator;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static Iterator func(ArrayList mylist) {
        Iterator it = mylist.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            if (!(element instanceof String)) {//Hints: use instanceof operator{
                continue;
            }

            break;
        }
        return it;

    }

    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(new StringReader("2 2\n" +
                "42\n" +
                "10\n" +
                "hello\n" +
                "java"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.add(sc.nextInt());
        }

        mylist.add("###");
        for (int i = 0; i < m; i++) {
            mylist.add(sc.next());
        }

        Iterator it = func(mylist);
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println((String) element);
        }
    }
}
