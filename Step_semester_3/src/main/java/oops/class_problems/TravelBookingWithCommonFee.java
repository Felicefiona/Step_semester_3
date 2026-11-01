import java.util.*;

public class TravelBookingWithCommonFee {
    static abstract class Booking {
        static final double BOOKING_FEE=50;
        double distance;
        Booking(double d) { distance=d; }
        abstract double baseFare();
        final double total() { return baseFare()+BOOKING_FEE; }
    }
    static class Bus extends Booking {
        Bus(double d) { super(d); }
        double baseFare() { return distance*2; }
    }
    static class Train extends Booking {
        Train(double d) { super(d); }
        double baseFare() { return distance*1.5; }
    }
    static class Flight extends Booking {
        Flight(double d) { super(d); }
        double baseFare() { return 2500+distance*4; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++) {
            String mode=s.next().toUpperCase();
            double km=s.nextDouble();
            Booking b;
            switch(mode) {
                case "BUS": b=new Bus(km); break;
                case "TRAIN": b=new Train(km); break;
                case "FLIGHT": b=new Flight(km); break;
                default: throw new IllegalArgumentException("Unknown mode");
            }
            System.out.printf("%s: %.2f%n",mode,b.total());
        }
    }
}