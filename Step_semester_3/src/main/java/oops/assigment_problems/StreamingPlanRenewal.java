import java.util.*;
import java.time.LocalDate;

public class StreamingPlanRenewal {
    interface Plan {
        int days();
    }
    static class Basic implements Plan {
        public int days() { return 30; }
    }
    static class Standard implements Plan {
        public int days() { return 90; }
    }
    static class Premium implements Plan {
        public int days() { return 365; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Plan> plans = new HashMap<>();
        plans.put("BASIC", new Basic());
        plans.put("STANDARD", new Standard());
        plans.put("PREMIUM", new Premium());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            LocalDate start = LocalDate.parse(sc.next());
            Plan plan = plans.get(type);
            if (plan == null) System.out.println("Invalid plan");
            else System.out.println(start.plusDays(plan.days()));
        }
        sc.close();
    }
}