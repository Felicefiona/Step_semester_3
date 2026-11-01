import java.util.Scanner;
public class StudentGradeAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int marks = sc.nextInt();
            char grade = marks >= 90 ? 'A' : marks >= 75 ? 'B' :
                         marks >= 60 ? 'C' : marks >= 40 ? 'D' : 'F';
            System.out.println("Grade " + grade);
        }
    }
}