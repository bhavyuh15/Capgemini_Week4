package mapinterface.wordfreaquencycounter;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "input.txt";  // Path to the input text file

        Map<String, Integer> wordFrequency = countWordFrequency(filePath);
        System.out.println(wordFrequency);
    }

    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " ");

                // Split the line into words
                String[] words = line.split("\\s+");

                // Count the frequency of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return frequencyMap;
    }
}

