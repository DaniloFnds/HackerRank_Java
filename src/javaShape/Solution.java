package javaShape;

import java.util.Scanner;

public class Solution {

    public static class Shape {
        private int length;
        private int breadth;

        public Shape(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        public void area() {
            System.out.println(length + " " + breadth);
            System.out.println(length * breadth);
        }

    }

    public static class Rectangle extends Shape {
        public Rectangle(int length, int breadth) {
            super(length, breadth);
        }

        @Override
        public void area() {
            super.area();
        }
    }


    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        final Scanner sc = new Scanner(System.in);
        final String[] s = sc.nextLine().split(" ");
        int l = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);


        Shape shape = new Rectangle(l, b);
        shape.area();
    }
}