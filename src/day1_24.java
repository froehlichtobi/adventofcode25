import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class day1_24 {
    public static void main(String[] args) {

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        String inputFile = "./src/input.in";
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNextInt()) {
                leftList.add(scanner.nextInt());
                rightList.add(scanner.nextInt());
            }
            Collections.sort(leftList);
            Collections.sort(rightList);
            int differenceSum = 0;
            for (int i = 0; i < leftList.size(); i++) {
                differenceSum += Math.abs(leftList.get(i) - rightList.get(i));
            }
            System.out.println(differenceSum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
    }
}
