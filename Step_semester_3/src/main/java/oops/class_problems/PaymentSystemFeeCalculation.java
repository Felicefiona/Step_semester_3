import java.util.*;

interface PaymentMethod {
    double calculate(double amount);
}
class CardPayment implements PaymentMethod {
    public double calculate(double amount) { return amount * 1.02; }
}
class WalletPayment implements PaymentMethod {
    public double calculate(double amount) { return amount * 1.01; }
}
class BankTransferPayment implements PaymentMethod {
    public double calculate(double amount) { return amount; }
}
public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, PaymentMethod> methods = new HashMap<>();
        methods.put("CARD", new CardPayment());
        methods.put("WALLET", new WalletPayment());
        methods.put("BANKTRANSFER", new BankTransferPayment());
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();
            double result = methods.get(type).calculate(amount);
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
