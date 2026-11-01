import java.util.*;

public class ElectricityConnectionBilling {
    static abstract class Connection {
        double units;
        Connection(double u) { units=u; }
        abstract double bill();
    }
    static class Home extends Connection {
        Home(double u) { super(u); }
        double bill() { return Math.min(units,100)*5+Math.max(0,units-100)*7; }
    }
    static class Shop extends Connection {
        Shop(double u) { super(u); }
        double bill() { return units*8+100; }
    }
    static class Factory extends Connection {
        Factory(double u) { super(u); }
        double bill() { return Math.max(1000,units*6); }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); double total=0;
        for(int i=0;i<n;i++) {
            String type=s.next().toUpperCase();
            double units=s.nextDouble();
            Connection c;
            switch(type) {
                case "HOME": c=new Home(units); break;
                case "SHOP": c=new Shop(units); break;
                case "FACTORY": c=new Factory(units); break;
                default: throw new IllegalArgumentException("Unknown connection");
            }
            total+=c.bill();
            System.out.printf("%s: %.2f%n",type,c.bill());
        }
        System.out.printf("Total: %.2f%n",total);
    }
}