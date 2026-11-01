import java.util.*;

public class CanteenBillingCounter {
    interface Customer {
        double bill(double amount);
    }
    static class Student implements Customer {
        public double bill(double amount) { return amount * 0.90; }
    }
    static class Staff implements Customer {
        public double bill(double amount) { return amount * 0.95; }
    }
    static class Guest implements Customer {
        public double bill(double amount) { return amount + 10; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Customer> customers = new HashMap<>();
        customers.put("STUDENT", new Student());
        customers.put("STAFF", new Staff());
        customers.put("GUEST", new Guest());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();
            Customer customer = customers.get(type);
            if (customer == null) System.out.println("Invalid customer type");
            else System.out.printf("%.2f%n", customer.bill(amount));
        }
        sc.close();
    }
}