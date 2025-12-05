import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {

        String inputFile = "./src/input.in";

        try (Scanner scanner = new Scanner(new File(inputFile));) {

            long sum = 0;
            int lengthOfBattery = 12;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<Integer> arrList = new ArrayList<>();
                ArrayList<Integer> resultList = new ArrayList<>();

                for (int i = 0; i < line.length(); i++) {
                    arrList.addLast(line.charAt(i) - '0');
                }
                int current = 0;
                int bestIndex = -1;
                for (int i = 0; i < lengthOfBattery; i++) {
                    resultList.add(0);
                    for (int j = bestIndex + 1; j < (arrList.size() - lengthOfBattery + i + 1); j++) {
                        current = arrList.get(j);
                        if (current > resultList.get(i)) {
                            resultList.set(i, current);
                            bestIndex = j;
                        }
                        if (resultList.get(i) == 9) break;
                    }
                }
                System.out.println(resultList);
                long nextSum = 0;
                for (int i = 0; i < lengthOfBattery; i++) {
                    nextSum += Math.pow(10,lengthOfBattery-i - 1) * resultList.get(i);
                }
                sum += nextSum;
            }
            System.out.println("sum: " + sum);


        } catch (
                FileNotFoundException e) {
            System.err.

                    println("File error: " + e.getMessage());
        }
    }
}
