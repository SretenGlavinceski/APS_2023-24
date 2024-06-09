package SLL.Excercises;

import java.util.Scanner;

public class Students {
    public static void removeStudent(SLL<Student> students) {
        SLLNode<Student> lowestGradeStudent = students.getFirst();
        SLLNode<Student> node = students.getFirst().succ;

        while (node != null) {
            if (lowestGradeStudent.element.getPoints() > node.element.getPoints()) {
                lowestGradeStudent = node;
            }
            node = node.succ;
        }

        students.delete(lowestGradeStudent);
    }

    public static void main(String[] args) {
        SLL<Student> studenti = new SLL<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int index = input.nextInt();
            String name = input.next();
            int points = input.nextInt();

            Student s1 = new Student(index, name, points);
            studenti.insertLast(s1);
        }
        removeStudent(studenti);
        System.out.println(studenti.toString());
    }
}

class Student {
    private int index;
    private String name;
    private int points;

    public Student(int index, String name, int points) {
        this.index = index;
        this.name = name;
        this.points = points;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }


    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
