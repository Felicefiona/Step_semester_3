import java.util.*;

public class PublicTransportFareCalculator {
    interface Fare {
        double calculate(double distance, double peakFactor);
    }

    static class Bus implements Fare {
        public double calculate(double distance, double peakFactor) {
            return Math.min(2 + 0.10 * distance, 10);
        }
    }

    static class Train implements Fare {
        public double calculate(double distance, double peakFactor) {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro implements Fare {
        public double calculate(double distance, double peakFactor) {
            return (1.50 + 0.20 * distance) * peakFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Fare> fares = new HashMap<>();
        fares.put("BUS", new Bus());
        fares.put("TRAIN", new Train());
        fares.put("METRO", new Metro());

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            double peakFactor = type.equals("METRO") ? sc.nextDouble() : 1.0;

            Fare fare = fares.get(type);
            if (fare == null) {
                System.out.println("Invalid transport type: " + type);
            } else {
                System.out.printf("%.2f%n", fare.calculate(distance, peakFactor));
            }
        }
        sc.close();
    }
}