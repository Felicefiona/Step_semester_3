import java.util.*;

public class HomeApplianceEnergyReport {
    interface SaverMode {
        double reduceUnits(double units);
    }
    static abstract class Appliance {
        double hours;
        Appliance(double h) { hours=h; }
        abstract double power();
        double units() { return power()*hours/1000; }
        double cost() { return units()*8; }
    }
    static class Fridge extends Appliance {
        Fridge(double h) { super(h); }
        double power() { return 150; }
    }
    static class AC extends Appliance implements SaverMode {
        AC(double h) { super(h); }
        double power() { return 1500; }
        public double reduceUnits(double u) { return u*.75; }
    }
    static class TV extends Appliance {
        TV(double h) { super(h); }
        double power() { return 100; }
    }
    static class Washer extends Appliance implements SaverMode {
        Washer(double h) { super(h); }
        double power() { return 500; }
        public double reduceUnits(double u) { return u*.75; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); double total=0;
        for(int i=0;i<n;i++) {
            String type=s.next().toUpperCase();
            double hours=s.nextDouble();
            boolean saver=s.hasNext("SAVER");
            if(saver) s.next();
            Appliance a;
            switch(type) {
                case "FRIDGE": a=new Fridge(hours); break;
                case "AC": a=new AC(hours); break;
                case "TV": a=new TV(hours); break;
                case "WASHER": a=new Washer(hours); break;
                default: throw new IllegalArgumentException("Unknown appliance");
            }
            if(saver && !(a instanceof SaverMode)) {
                System.out.println(type+": saver mode not supported");
                continue;
            }
            double units=a.units();
            if(saver) units=((SaverMode)a).reduceUnits(units);
            double cost=units*8;
            total+=cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n",type,units,cost);
        }
        System.out.printf("Total Cost: %.2f%n",total);
    }
}