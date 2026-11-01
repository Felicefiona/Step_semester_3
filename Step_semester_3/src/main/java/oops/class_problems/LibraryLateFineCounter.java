import java.util.*;

public class LibraryLateFineCounter {
    static abstract class Item {
        String title; int days;
        Item(String t,int d) { title=t;days=d; }
        abstract double fine();
    }
    static class Book extends Item {
        Book(String t,int d) { super(t,d); }
        double fine() { return days*2.0; }
    }
    static class DVD extends Item {
        DVD(String t,int d) { super(t,d); }
        double fine() { return Math.min(days*5.0,50); }
    }
    static class Magazine extends Item {
        Magazine(String t,int d) { super(t,d); }
        double fine() { return days*1.0; }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); double total=0;
        for(int i=0;i<n;i++) {
            String type=s.next().toUpperCase(),title=s.next();
            int days=s.nextInt();
            Item item;
            switch(type) {
                case "BOOK": item=new Book(title,days); break;
                case "DVD": item=new DVD(title,days); break;
                case "MAGAZINE": item=new Magazine(title,days); break;
                default: throw new IllegalArgumentException("Unknown item");
            }
            total+=item.fine();
            System.out.printf("%s: %.2f%n",title,item.fine());
        }
        System.out.printf("Total Fines: %.2f%n",total);
    }
}