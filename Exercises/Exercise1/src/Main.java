

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Session session = new Session();
        Random rand = new Random();

        // Add 10 Full-Time students
        for (int i = 1; i <= 10; i++) {
            FullTimeStudent ftStudent = new FullTimeStudent("FT_Student_" + i, rand.nextInt(101), rand.nextInt(101));
            for (int j = 0; j < 15; j++) {
                ftStudent.addQuizScore(rand.nextInt(101));
            }
            session.addStudent(ftStudent);
        }

        // Add 10 Part-Time students
        for (int i = 1; i <= 10; i++) {
            PartTimeStudent ptStudent = new PartTimeStudent("PT_Student_" + i);
            for (int j = 0; j < 15; j++) {
                ptStudent.addQuizScore(rand.nextInt(101));
            }
            session.addStudent(ptStudent);
        }

        // Call methods and print outputs
        System.out.println("Average Quiz Score per Student: " + session.getAverageQuizScorePerStudent());
        session.printQuizScoresAscending();
        session.printPartTimeStudentNames();
        session.printFullTimeExamScores();
    }
}
