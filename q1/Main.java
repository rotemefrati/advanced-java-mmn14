package main.java.com.maman14.q1;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // creating an array of students and an array of average grades
        Student[] studentsArray = newStudentsArray();
        Integer[] avgGrades = newAverageGradesArray();

        try {
            // creating an AssociationTable with students and average grades
            AssociationTable<Student, Integer> studentsTable = new AssociationTable<>(studentsArray, avgGrades);

            // display the initial list of students
            System.out.println("Initial list of students:");
            displayStudents(studentsTable);

            // add a new student
            Student newStudent = new Student("Doron", "Avraham", "2086673305", "2001");
            studentsTable.add(newStudent, 97);

            System.out.println("\nList of students after adding a new student:");
            displayStudents(studentsTable);

            // update average grade for Idan
            studentsTable.add(studentsArray[1], 60);

            // remove Yosi
            studentsTable.remove(studentsArray[0]);

            // display the updated list of students
            System.out.println("\nlist of students after grade change and student removal:");
            displayStudents(studentsTable);
        }
        catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // helper method to create an array of students
    private static Student[] newStudentsArray() {
        Student[] students = new Student[3];
        students[0] = new Student("Yosi", "Abutbul", "345997009", "1990");
        students[1] = new Student("Idan", "Shalom", "398554004", "1995");
        students[2] = new Student("Dana", "Cohen", "0338762217", "1972");
        return students;
    }

    // helper method to create an array of average grades
    private static Integer[] newAverageGradesArray() {
        Integer[] avgGrades = new Integer[3];
        avgGrades[0] = 90;
        avgGrades[1] = 74;
        avgGrades[2] = 86;
        return avgGrades;
    }

    // helper method to display students and their average grades
    private static void displayStudents(AssociationTable<Student, Integer> studentsTable) {
        Iterator<Student> iterator = studentsTable.keyIterator();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student + ", Average Grade: " + studentsTable.get(student));
        }
    }
}