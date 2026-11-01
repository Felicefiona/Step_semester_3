import java.util.Scanner;
public class DigitSumNumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong(), temp = number, reverse = 0, sum = 0;
        while (temp > 0) {
            long digit = temp % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }
}