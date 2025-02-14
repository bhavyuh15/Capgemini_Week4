package countwords;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) {
        String fileName = "input.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }

        // Sort and display top 5 most frequent words
        List<Map.Entry<String, Integer>> topWords = wordCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 most frequent words:");
        topWords.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}