import java.util.Scanner;
import java.util.Locale;
class Student {
    String name;
    int[] marks;
    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    double average() {
        int total = 0;
        for (int mark : marks) total += mark;
        return total / 3.0;
    }
    char grade() {
        double avg = average();
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }
}
public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) marks[j] = sc.nextInt();
            Student student = new Student(name, marks);
            System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), student.average(), student.grade());
        }
    }
}