package hackerrank.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(Student::compare);

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}

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

    public static int compare(Student s1, Student s2) {

        Double cpga1 = s1.getCgpa();
        Double cpga2 = s2.getCgpa();

        if (Math.abs(cpga1 - cpga2) > 0.001d) {
            return Double.compare(cpga2, cpga1);
        }

        int compareNames = s1.getFname().compareTo(s2.getFname());

        if (compareNames != 0) {
            return compareNames;
        }

        return Integer.compare(s1.getId(), s2.getId());
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