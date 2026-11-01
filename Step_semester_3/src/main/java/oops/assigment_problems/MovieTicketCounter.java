import java.util.*;

public class MovieTicketCounter {
    static abstract class Ticket {
        static final double CONVENIENCE_FEE=20;
        int count;
        Ticket(int c) { count=c; }
        abstract double price();
        final double amount() { return (price()+CONVENIENCE_FEE)*count; }
    }
    static class Regular extends Ticket {
        Regular(int c) { super(c); }
        double price() { return 150; }
    }
    static class Premium extends Ticket {
        Premium(int c) { super(c); }
        double price() { return 250; }
    }
    static class Recliner extends Ticket {
        Recliner(int c) { super(c); }
        double price() { return 400; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); double total=0;
        for(int i=0;i<n;i++) {
            String seat=s.next().toUpperCase(); int count=s.nextInt();
            Ticket t;
            switch(seat) {
                case "REGULAR": t=new Regular(count); break;
                case "PREMIUM": t=new Premium(count); break;
                case "RECLINER": t=new Recliner(count); break;
                default: throw new IllegalArgumentException("Unknown seat");
            }
            total+=t.amount();
            System.out.printf("%s: %.2f%n",seat,t.amount());
        }
        System.out.printf("Total: %.2f%n",total);
    }
}