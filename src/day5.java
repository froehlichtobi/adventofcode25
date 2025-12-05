import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;


public class day5 {
    public static void main(String[] args) {

        String inputFile = "./src/input.in";
        List<Long[]> numberList = new ArrayList<>();
        long sum = 0;

        try (
                Scanner scanner = new Scanner(new File(inputFile));
        ) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    break;
                String[] parts = line.split("-");
                long lower = Long.parseLong(parts[0]);
                long upper = Long.parseLong(parts[1]);
                numberList.add(new Long[]{lower, upper});
            }
            //sort array by the lower bound
            numberList.sort(Comparator.comparingLong(arr -> arr[0]));
            List<Long[]> limits = new ArrayList<>();

            long lower = numberList.getFirst()[0];
            long upper = numberList.getFirst()[1];
            numberList.removeFirst();

            while (!numberList.isEmpty()) {
                long nextLower = numberList.getFirst()[0];
                long nextUpper = numberList.getFirst()[1];

                if (nextLower <= upper) {
                    upper = Math.max(upper, nextUpper);
                } else {
                    limits.add(new Long[]{lower, upper});
                    lower = nextLower;
                    upper = nextUpper;
                }
                numberList.removeFirst();
            }
            limits.add(new Long[]{lower, upper});
            for (Long[] arr : limits) {
                sum += arr[1] - arr[0] + 1;
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
}
