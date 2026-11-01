import java.util.*;

public class GardenPlotAreaReport {
    static abstract class Plot {
        String owner;
        Plot(String owner) { this.owner = owner; }
        abstract double area();
        abstract String shape();
    }
    static class Circle extends Plot {
        double r;
        Circle(String o, double r) { super(o); this.r = r; }
        double area() { return Math.PI * r * r; }
        String shape() { return "CIRCLE"; }
    }
    static class Rectangle extends Plot {
        double l,w;
        Rectangle(String o,double l,double w) { super(o);this.l=l;this.w=w; }
        double area() { return l*w; }
        String shape() { return "RECTANGLE"; }
    }
    static class Triangle extends Plot {
        double b,h;
        Triangle(String o,double b,double h) { super(o);this.b=b;this.h=h; }
        double area() { return 0.5*b*h; }
        String shape() { return "TRIANGLE"; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Map<String,java.util.function.Function<String,Plot>> unused=new HashMap<>();
        int n=s.nextInt(); double total=0;
        for(int i=0;i<n;i++) {
            String type=s.next().toUpperCase(), owner=s.next();
            Plot p;
            switch(type) {
                case "CIRCLE": p=new Circle(owner,s.nextDouble()); break;
                case "RECTANGLE": p=new Rectangle(owner,s.nextDouble(),s.nextDouble()); break;
                case "TRIANGLE": p=new Triangle(owner,s.nextDouble(),s.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown shape: "+type);
            }
            double a=p.area(); total+=a;
            System.out.printf("%s (%s): %.2f%n",p.owner,p.shape(),a);
        }
        System.out.printf("Total Area: %.2f%n",total);
    }
}