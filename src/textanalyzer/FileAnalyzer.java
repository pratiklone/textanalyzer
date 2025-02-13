package textanalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileAnalyzer {
    private String filePath;
    private int wordCount;
    private int lineCount;
    private int charCount;
    private Map<String, Integer> wordFrequency;

    public FileAnalyzer(String filePath) {
        this.filePath = filePath;
        this.wordFrequency = new HashMap<>();
    }

    public void analyze() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        }
    }

    private void processLine(String line) {
        lineCount++;
        charCount += line.length();

        String[] words = line.toLowerCase()
                .replaceAll("[^a-zA-Z0-9\\s]", "")
                .split("\\s+");

        wordCount += words.length;

        Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .forEach(word -> wordFrequency.merge(word, 1, Integer::sum));
    }

    public textanalyzer.TextStatistics getStatistics() {
        return new textanalyzer.TextStatistics(wordCount, lineCount, charCount, wordFrequency);
    }
}
