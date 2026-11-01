import java.util.*;

public class CollegeFeeCounter {
    interface BusUser {
        double transportFee();
    }
    static abstract class Student {
        String name;
        Student(String n) { name=n; }
        abstract double tuitionAndOtherFees();
        double total() {
            return tuitionAndOtherFees() +
                (this instanceof BusUser ? ((BusUser)this).transportFee() : 0);
        }
    }
    static class DayScholar extends Student implements BusUser {
        DayScholar(String n) { super(n); }
        double tuitionAndOtherFees() { return 40000; }
        public double transportFee() { return 12000; }
    }
    static class Hosteller extends Student {
        Hosteller(String n) { super(n); }
        double tuitionAndOtherFees() { return 100000; }
    }
    static class Scholar extends Student implements BusUser {
        Scholar(String n) { super(n); }
        double tuitionAndOtherFees() { return 20000; }
        public double transportFee() { return 12000; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); double total=0;
        for(int i=0;i<n;i++) {
            String type=s.next().toUpperCase(),name=s.next();
            Student st;
            switch(type) {
                case "DAY_SCHOLAR": st=new DayScholar(name); break;
                case "HOSTELLER": st=new Hosteller(name); break;
                case "SCHOLAR": st=new Scholar(name); break;
                default: throw new IllegalArgumentException("Unknown student");
            }
            total+=st.total();
            System.out.printf("%s: %.2f%n",name,st.total());
        }
        System.out.printf("Total Collected: %.2f%n",total);
    }
}