import java.util.*;

public class CityCabFareMeter {
    interface NightService {
        double nightFare(double fare);
    }
    static abstract class Cab {
        static final double MINIMUM_FARE=100;
        abstract double rate();
        double fare(double km) { return Math.max(MINIMUM_FARE,km*rate()); }
    }
    static class Mini extends Cab {
        double rate() { return 10; }
    }
    static class Sedan extends Cab implements NightService {
        double rate() { return 14; }
        public double nightFare(double fare) { return fare*1.2; }
    }
    static class SUV extends Cab implements NightService {
        double rate() { return 18; }
        public double nightFare(double fare) { return fare*1.2; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); double total=0;
        for(int i=0;i<n;i++) {
            String type=s.next().toUpperCase();
            double km=s.nextDouble();
            String time=s.next().toUpperCase();
            Cab c;
            switch(type) {
                case "MINI": c=new Mini(); break;
                case "SEDAN": c=new Sedan(); break;
                case "SUV": c=new SUV(); break;
                default: throw new IllegalArgumentException("Unknown cab");
            }
            if(time.equals("NIGHT") && !(c instanceof NightService)) {
                System.out.println(type+": night service not available");
                continue;
            }
            double fare=c.fare(km);
            if(time.equals("NIGHT")) fare=((NightService)c).nightFare(fare);
            total+=fare;
            System.out.printf("%s: %.2f%n",type,fare);
        }
        System.out.printf("Total: %.2f%n",total);
    }
}