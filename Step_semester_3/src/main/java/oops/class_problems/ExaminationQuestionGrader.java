import java.util.*;
import java.util.regex.*;

public class ExaminationQuestionGrader {
    interface Question {
        double grade(String answer);
    }

    static class MCQ implements Question {
        String correct;
        MCQ(String correct) { this.correct = correct; }
        public double grade(String answer) {
            return correct.equalsIgnoreCase(answer) ? 100 : 0;
        }
    }

    static class TrueFalse implements Question {
        String correct;
        TrueFalse(String correct) { this.correct = correct; }
        public double grade(String answer) {
            return correct.equalsIgnoreCase(answer) ? 100 : 0;
        }
    }

    static class Essay implements Question {
        String[] keywords;
        Essay(String keywordText) {
            keywords = keywordText.split(",");
        }
        public double grade(String answer) {
            int found = 0;
            for (String keyword : keywords) {
                if (!keyword.trim().isEmpty() &&
                    answer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                    found++;
                }
            }
            if (found >= 2) return 75;
            if (found == 1) return 50;
            return 0;
        }
    }

    static List<String> parse(String line) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (matcher.find()) {
            tokens.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, java.util.function.Function<String, Question>> factories = new HashMap<>();
        factories.put("MCQ", MCQ::new);
        factories.put("TF", TrueFalse::new);
        factories.put("ESSAY", Essay::new);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            List<String> t = parse(sc.nextLine());
            Question q = factories.get(t.get(0).toUpperCase()).apply(t.get(2));
            double percentage = q.grade(t.get(3));
            double earned = Double.parseDouble(t.get(4)) * percentage / 100.0;
            total += earned;
            System.out.printf("Question %d: %.2f / %s%n",
                    i + 1, earned, t.get(4));
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}