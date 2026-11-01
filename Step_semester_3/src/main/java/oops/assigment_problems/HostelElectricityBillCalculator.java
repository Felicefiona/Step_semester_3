import java.util.*;

public class HostelElectricityBillCalculator {
    interface Room {
        double bill(double units, int occupants);
    }
    static class Single implements Room {
        public double bill(double units, int occupants) { return units * 8; }
    }
    static class Shared implements Room {
        public double bill(double units, int occupants) {
            return occupants > 0 ? units * 6 / occupants : 0;
        }
    }
    static class AC implements Room {
        public double bill(double units, int occupants) { return units * 10 + 200; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Room> rooms = new HashMap<>();
        rooms.put("SINGLE", new Single());
        rooms.put("SHARED", new Shared());
        rooms.put("AC", new AC());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();
            int occupants = sc.nextInt();
            Room room = rooms.get(type);
            if (room == null) System.out.println("Invalid room type");
            else System.out.printf("%.2f%n", room.bill(units, occupants));
        }
        sc.close();
    }
}