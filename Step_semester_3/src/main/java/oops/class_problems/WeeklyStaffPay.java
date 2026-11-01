import java.util.*;

public class WeeklyStaffPay {
    static abstract class Staff {
        String name;
        Staff(String name) { this.name=name; }
        abstract double pay();
    }
    static class FullTime extends Staff {
        double salary;
        FullTime(String n,double s) { super(n);salary=s; }
        double pay() { return salary; }
    }
    static class Hourly extends Staff {
        double hours,rate;
        Hourly(String n,double h,double r) { super(n);hours=h;rate=r; }
        double pay() { return Math.min(hours,40)*rate+Math.max(0,hours-40)*rate*1.5; }
    }
    static class Intern extends Staff {
        double stipend;
        Intern(String n,double s) { super(n);stipend=s; }
        double pay() { return stipend; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); double total=0;
        for(int i=0;i<n;i++) {
            String type=s.next().toUpperCase(),name=s.next();
            Staff p;
            switch(type) {
                case "FULLTIME": p=new FullTime(name,s.nextDouble()); break;
                case "HOURLY": p=new Hourly(name,s.nextDouble(),s.nextDouble()); break;
                case "INTERN": p=new Intern(name,s.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown staff type");
            }
            total+=p.pay();
            System.out.printf("%s: %.2f%n",p.name,p.pay());
        }
        System.out.printf("Total Payroll: %.2f%n",total);
    }
}