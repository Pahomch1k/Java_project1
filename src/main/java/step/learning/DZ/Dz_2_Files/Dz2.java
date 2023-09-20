package step.learning.DZ.Dz_2_Files;
import java.io.*;
import java.util.Random;

import java.io.*;
import java.util.Random;

public class Dz2 {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введіть максимальну кількість рядків у файлі:");
        int maxLines = Integer.parseInt(reader.readLine());

        String fileName = "random_strings.txt";
        generateFile(fileName, maxLines);
        findLongestLine(fileName);
    }

    private void generateFile(String fileName, int maxLines) throws IOException {
        Random random = new Random();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < maxLines; i++) {
            int lineLength = 1 + random.nextInt(200);
            for (int j = 0; j < lineLength; j++) {
                writer.write((char) ('a' + random.nextInt(26)));
            }
            writer.newLine();
        }

        writer.close();
    }

    private void findLongestLine(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String longestLine = "";
        String line;
        int lineNumber = 0;
        int longestLineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (line.length() > longestLine.length()) {
                longestLine = line;
                longestLineNumber = lineNumber;
            }
        }

        reader.close();

        System.out.printf("найдовший рядок номер %d з довжиною %d символ: %s%n",
                longestLineNumber, longestLine.length(), longestLine);
    }
}