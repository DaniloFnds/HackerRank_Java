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
                if (Double.compare(o1.getCgpa(), o2.getCgpa()) == 0) {
                    if (o1.getName().compareTo(o2.getName()) == 0) {
                        return Integer.compare(o1.getId(), o2.getId());
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
                return Double.compare(o2.getCgpa(), o1.getCgpa());
            }
        });
        events.forEach(e -> {

            final String[] s = e.split(" ");
            if (s.length == 1) {
                queue.remove();
                System.out.println();
            } else {
                final String event = s[0];
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
        });
        System.out.println(queue);

        return new ArrayList<>(queue);
    }

}

class Student {
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", cgpa=" + cgpa +
                '}';
    }

}


public class Solution {
    private final static Scanner scan = new Scanner(new StringReader("12\n" +
            "ENTER John 3.75 50\n" +
            "ENTER Mark 3.8 24\n" +
            "ENTER Shafaet 3.7 35\n" +
            "SERVED\n" +
            "SERVED\n" +
            "ENTER Samiha 3.85 36\n" +
            "SERVED\n" +
            "ENTER Ashley 3.9 42\n" +
            "ENTER Maria 3.6 46\n" +
            "ENTER Anik 3.95 49\n" +
            "ENTER Dan 3.95 50\n" +
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