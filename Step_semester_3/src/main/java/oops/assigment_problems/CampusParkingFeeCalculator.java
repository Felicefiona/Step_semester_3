import java.util.*;

public class CampusParkingFeeCalculator {
    interface Vehicle {
        double fee(int hours);
    }
    static class Bike implements Vehicle {
        public double fee(int hours) { return hours * 10; }
    }
    static class Car implements Vehicle {
        public double fee(int hours) {
            return hours <= 0 ? 0 : 30 + (hours - 1) * 20;
        }
    }
    static class Truck implements Vehicle {
        public double fee(int hours) { return Math.max(100, hours * 50); }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("BIKE", new Bike());
        vehicles.put("CAR", new Car());
        vehicles.put("TRUCK", new Truck());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();
            Vehicle v = vehicles.get(type);
            if (v == null) System.out.println("Invalid vehicle type");
            else System.out.printf("%.2f%n", v.fee(hours));
        }
        sc.close();
    }
}