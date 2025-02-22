

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Session {
    private List<Student> students;

    public Session() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (students.size() < 20) {
            students.add(student);
        }
    }

    public double getAverageQuizScorePerStudent() {
        return students.stream().mapToDouble(Student::getAverageQuizScore).average().orElse(0.0);
    }

    public void printQuizScoresAscending() {
        List<Integer> allScores = new ArrayList<>();
        for (Student student : students) {
            allScores.addAll(student.getQuizScores());
        }
        Collections.sort(allScores);
        System.out.println("Quiz Scores in Ascending Order: " + allScores);
    }

    public void printPartTimeStudentNames() {
        System.out.println("Part-Time Students:");
        for (Student student : students) {
            if (student instanceof PartTimeStudent) {
                System.out.println(student.getName());
            }
        }
    }

    public void printFullTimeExamScores() {
        System.out.println("Full-Time Student Exam Scores:");
        for (Student student : students) {
            if (student instanceof FullTimeStudent) {
                FullTimeStudent ftStudent = (FullTimeStudent) student;
                System.out.println(ftStudent.getName() + " - Exam 1: " + ftStudent.getExamScore1() + ", Exam 2: " + ftStudent.getExamScore2());
            }
        }
    }
}
