package string.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StopWordFilteredWordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        String cleanedFeedback = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedFeedback.split("\\s+");
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        Map<String, Integer> frequencies = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
            }
        }

        List<String> sortedWords = new ArrayList<>(frequencies.keySet());
        Collections.sort(sortedWords, new Comparator<String>() {
            @Override
            public int compare(String firstWord, String secondWord) {
                return frequencies.get(secondWord).compareTo(frequencies.get(firstWord));
            }
        });

        for (String word : sortedWords) {
            System.out.println(word + ": " + frequencies.get(word));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();
        printFilteredWordFrequency(feedback);
        scanner.close();
    }
}