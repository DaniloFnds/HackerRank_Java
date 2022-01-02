package javaPriorityQueue;

import java.io.StringReader;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */

class Priorities {

    public List<Student> getStudents(List<String> events) {

        final PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                System.out.println(o1);
                System.out.println(o2);
                System.out.println("---------------");
                if (o2.getCgpa() == o1.getCgpa()) {
                    if (o1.getName().equals(o2.getName())) {
                        return Integer.compare(o1.getId(), o2.getId());
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
                return Double.compare(o2.getCgpa(), o1.getCgpa());
            }
        });
        for (String e : events) {
            final String[] s = e.split(" ");
            final String event = s[0];
            if ("SERVED".equals(event) && queue.size() == 0) {
                continue;
            }
            if (s.length == 1) {
                queue.remove();
            } else {
                final String name = s[1];
                final double cgpa = Double.parseDouble(s[2]);
                final int id = Integer.parseInt(s[3]);
                if ("ENTER".equals(event)) {
                    queue.add(new Student(name, id, cgpa));
                }

                if ("SERVED".equals(event)) {
                    queue.remove(new Student(name, id, cgpa));
                }
                System.out.println(queue);
            }
        };
        final ArrayList<Student> students = new ArrayList<>(queue);
        Collections.sort(students);
        return students;
    }

}

class Student implements Comparable<Student> {
    private String name;
    private int id;
    private double cgpa;

    public Student(String name, int id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Student o2) {
        if (o2.getCgpa() == this.getCgpa()) {
            if (this.getName().equals(o2.getName())) {
                return Integer.compare(this.getId(), o2.getId());
            } else {
                return this.getName().compareTo(o2.getName());
            }
        }
        return Double.compare(o2.getCgpa(), this.getCgpa());
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(new StringReader("30\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED"));
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}