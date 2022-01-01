package javaSort;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new StringReader("5\n" +
                "33 Rumpa 3.68\n" +
                "85 Ashis 3.85\n" +
                "56 Samiha 3.75\n" +
                "19 Samara 3.75\n" +
                "22 Fahim 3.76"));
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0 ) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = Double.parseDouble(in.next());

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, (o1, o2) -> {
            if (Double.compare(o1.getCgpa(), o2.getCgpa()) == 0) {
                if (o1.getFname().compareTo(o2.getFname()) == 0) {
                    return Integer.compare(o1.getId(), o2.getId());
                } else {
                    return o1.getFname().compareTo(o2.getFname());
                }
            }
            return Double.compare(o2.getCgpa(), o1.getCgpa());
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}



