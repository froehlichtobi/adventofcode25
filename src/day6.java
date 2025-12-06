import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class day6 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("./src/input.in").toPath());

        int maxLen = 0;
        for (String line : lines) {
            maxLen = Math.max(maxLen, line.length());
        }
        List<String> columns = new ArrayList<>();
        String line = "";
        for (int j = maxLen - 1; j >= 0; j--) {
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).length() > j)
                    line += lines.get(i).charAt(j);
            }
            line += " ";
        }
        String[] operations = line.split("(?<=[+*])");
        for (int i = 0; i < operations.length; i++) {
            operations[i] = operations[i].trim();
        }
        System.out.println(Arrays.toString(operations));
        long totalSum = 0;
        for (int i = 0; i < operations.length; i++) {
            if (!operations[i].isEmpty()) {
                String numsOnly = operations[i].substring(0, operations[i].length() - 1);
                String[] numsSeparated = numsOnly.split("\\s");
                int[] numbers = new int[numsSeparated.length];
                char operation = operations[i].charAt(operations[i].length() - 1);
                boolean addition = operation == '+';
                long localSum = 0;
                if (!addition)
                    localSum++;
                for (int j = 0; j < numbers.length; j++) {
                    if (numsSeparated[j] != "") {
                        numbers[j] = Integer.parseInt(numsSeparated[j]);
                        if (addition)
                            localSum += numbers[j];
                        else
                            localSum *= numbers[j];
                    }
                }
                totalSum += localSum;
            }
        }
        System.out.println(totalSum);
    }
}