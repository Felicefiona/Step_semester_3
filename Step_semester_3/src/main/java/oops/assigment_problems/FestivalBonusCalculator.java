import java.util.*;

public class FestivalBonusCalculator {
    interface Bonus {
        double calculate(double salary);
    }
    static class FullTime implements Bonus {
        public double calculate(double salary) { return salary * 0.10; }
    }
    static class PartTime implements Bonus {
        public double calculate(double salary) { return salary * 0.05; }
    }
    static class Intern implements Bonus {
        public double calculate(double salary) { return 2000; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Bonus> bonuses = new HashMap<>();
        bonuses.put("FULLTIME", new FullTime());
        bonuses.put("PARTTIME", new PartTime());
        bonuses.put("INTERN", new Intern());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double salary = sc.nextDouble();
            Bonus bonus = bonuses.get(type);
            if (bonus == null) System.out.println("Invalid employee type");
            else System.out.printf("%.2f%n", bonus.calculate(salary));
        }
        sc.close();
    }
}