import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Input and output file names
        String inputFile = "./src/input1.in";
        String outputFile = "./src/output.out";
        int state = 50;
        int password = 0;
        try (
                Scanner scanner = new Scanner(new File(inputFile));
                PrintWriter writer = new PrintWriter(outputFile);
        ) {
            while (scanner.hasNextLine()) {
                String token = scanner.nextLine();
                boolean direction = token.charAt(0) == 'R';
                int turns = Integer.parseInt(token.substring(1));
                System.out.println("state: " + state + " token: " + token + " password: " + password);
                if (turns >= 100) {
                    password += turns / 100;
                    turns = turns % 100;
                    if (turns == 0)
                        continue;
                }

                if (direction) {
                    state += turns;
                    if (state >= 100) {
                        state -= 100;
                        if (state != 0)
                            password++;
                    }
                } else {
                    int oldState = state;
                    state -= turns;
                    if (state < 0) {
                        state += 100;
                        if (state != 0 && oldState != 0)
                            password++;
                    }
                }
                if (state == 0)
                    password++;

                System.out.println("state: " + state + " token: " + token + " password: " + password);
                System.out.println();
            }

//            while (scanner.hasNextLine()) {
//                String token = scanner.nextLine().trim();
//                System.out.println("BEFORE: Token: " + token + " state: " + state + " password: " + password);
//
//                boolean directionRight = token.charAt(0) == 'R';
//                int turns = Integer.parseInt(token.substring(1));
//
//                int crosses;
//                if (directionRight) {
//                    crosses = (state + turns) / 100;
//                    state = (state + turns) % 100;
//                } else {
//                    crosses = (turns + (100 - state)) / 100;
//                    int rem = turns % 100;
//                    state = (state - rem + 100) % 100;
//                }
//
//                password += crosses;
            System.out.println(password);

        } catch (
                FileNotFoundException e) {
            System.err.println("File error: " + e.getMessage());
        }
    }
}