package textanalyzer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/sample.txt";

        try {
            FileAnalyzer analyzer = new FileAnalyzer(filePath);
            analyzer.analyze();
            textanalyzer.TextStatistics stats = analyzer.getStatistics();
            System.out.println(stats);
        } catch (IOException e) {
            System.err.println("Error analyzing file: " + e.getMessage());
        }
    }
}
