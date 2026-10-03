package string.assigment_problems;

import java.util.Scanner;

public class LibraryIsbnNormalizerValidator {
    static String normalizeCode(String raw) {
        String code = raw.trim();
        int publisherLength = Math.min(3, code.length());
        return code.substring(0, publisherLength).toUpperCase() + code.substring(publisherLength);
    }

    static String validateAndFormat(String code) {
        String normalizedCode = normalizeCode(code);
        if (normalizedCode.length() != 13) {
            return "Invalid: wrong length";
        }

        String publisherCode = normalizedCode.substring(0, 3);
        for (int index = 0; index < publisherCode.length(); index++) {
            if (!Character.isLetter(publisherCode.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = normalizedCode.substring(3);
        for (int index = 0; index < body.length(); index++) {
            if (!Character.isDigit(body.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);
        return new StringBuilder()
                .append("[").append(publisherCode).append("] YEAR: ")
                .append(year).append(" | CATALOG: ").append(catalog)
                .toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ISBN code: ");
        String code = scanner.nextLine();
        System.out.println(validateAndFormat(code));
        scanner.close();
    }
}