import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {

        String inputFile = "./src/input.in";

        try (
                Scanner scanner = new Scanner(new File(inputFile));
        ) {
            scanner.useDelimiter(",");
            long solution = 0;

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] parts = line.split("-");
                long first = Long.parseLong(parts[0]);
                long second = Long.parseLong(parts[1]);

                for (long i = first; i <= second; i++) {

                    String checkSquare = Long.toString(i);
                    int middle = checkSquare.length() / 2;
                    int length = checkSquare.length();

                    for (int j = 0; j < middle; j++) {
                        int subLength = middle - j;
                        if (length % subLength != 0)
                            continue;
                        int times = length / subLength;
                        String sub = checkSquare.substring(0, subLength);
                        sub = sub.repeat(times);
                        if (sub.equals(checkSquare)) {
                            solution += i;
                            System.out.println("sub: " + sub + " checksquare: " + checkSquare);
                            break;
                        }
                    }

                }
            }
            System.out.println("Solution: " + solution);
        } catch (
                FileNotFoundException e) {
            System.err.println("File error: " + e.getMessage());
        }
    }
}
