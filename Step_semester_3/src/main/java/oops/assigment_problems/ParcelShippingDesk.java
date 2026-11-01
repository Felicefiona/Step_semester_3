import java.util.*;

public class ParcelShippingDesk {
    interface Insurable {
        double insurance();
    }
    static abstract class Parcel {
        double weight,value;
        Parcel(double w,double v) { weight=w;value=v; }
        abstract double charge();
        double insurance() {
            return this instanceof Insurable ? ((Insurable)this).insurance() : 0;
        }
        double total() { return charge()+insurance(); }
    }
    static class Standard extends Parcel {
        Standard(double w,double v) { super(w,v); }
        double charge() { return 40+10*weight; }
    }
    static class Express extends Parcel implements Insurable {
        Express(double w,double v) { super(w,v); }
        double charge() { return 80+15*weight; }
        public double insurance() { return value*.02; }
    }
    static class Fragile extends Parcel implements Insurable {
        Fragile(double w,double v) { super(w,v); }
        double charge() { return 40+10*weight+50; }
        public double insurance() { return value*.02; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); double grand=0;
        for(int i=0;i<n;i++) {
            String type=s.next().toUpperCase();
            double w=s.nextDouble(),v=s.nextDouble();
            Parcel p;
            switch(type) {
                case "STANDARD": p=new Standard(w,v); break;
                case "EXPRESS": p=new Express(w,v); break;
                case "FRAGILE": p=new Fragile(w,v); break;
                default: throw new IllegalArgumentException("Unknown parcel");
            }
            grand+=p.total();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type,p.charge(),p.insurance(),p.total());
        }
        System.out.printf("Grand Total: %.2f%n",grand);
    }
}