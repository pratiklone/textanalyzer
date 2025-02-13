package textanalyzer;

import java.util.Map;
import java.util.stream.Collectors;

public class TextStatistics {
    private int wordCount;
    private int lineCount;
    private int charCount;
    private Map<String, Integer> wordFrequency;

    public TextStatistics(int wordCount, int lineCount, int charCount, Map<String, Integer> wordFrequency) {
        this.wordCount = wordCount;
        this.lineCount = lineCount;
        this.charCount = charCount;
        this.wordFrequency = wordFrequency;
    }

    public Map<String, Integer> getTopWords(int limit) {
        return wordFrequency.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(limit)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Text Analysis Results:\n");
        sb.append("Word count: ").append(wordCount).append("\n");
        sb.append("Line count: ").append(lineCount).append("\n");
        sb.append("Character count: ").append(charCount).append("\n");
        sb.append("\nTop 5 most frequent words:\n");

        getTopWords(5).forEach((word, count) ->
                sb.append(word).append(": ").append(count).append(" times\n")
        );

        return sb.toString();
    }
}

