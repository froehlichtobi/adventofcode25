import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class day4 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{},{1},{}};
        System.out.println(arr[0].length);
        String inputFile = "./src/input.in";
        try (
                Scanner scanner = new Scanner(new File(inputFile));
        ) {
            List<String> lines = new ArrayList<>();

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            char[][] storage = new char[lines.size()][lines.get(0).length()];

            for (int i = 0; i < lines.size(); i++) {
                for (int j = 0; j < lines.get(0).length(); j++) {
                    storage[i][j] = lines.get(i).charAt(j);
                }
            }

            boolean removed = false;
            int rolls = 0;
            do {
                removed = false;
                for (int i = 0; i < storage.length; i++) {
                    for (int j = 0; j < storage[0].length; j++) {
                        if (storage[i][j] != '@')
                            continue;
                        int neighbors = getNeighbors(i, j, storage);
                        if (neighbors <= 3){
                            rolls++;
                            storage[i][j] = 'x';
                            removed = true;
                        }
                    }
                }
            }
            while (removed);

            System.out.println(rolls);

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    private static int getNeighbors(int i, int j, char[][] storage) {
        int neighbors = 0;
        if (i - 1 >= 0) {
            if (j - 1 >= 0)
                if (storage[i - 1][j - 1] == '@')
                    neighbors++;
            if (j + 1 < storage[0].length)
                if (storage[i - 1][j + 1] == '@')
                    neighbors++;
            if (storage[i - 1][j] == '@')
                neighbors++;
        }
        if (i + 1 < storage.length) {
            if (j - 1 >= 0)
                if (storage[i + 1][j - 1] == '@')
                    neighbors++;
            if (j + 1 < storage[0].length)
                if (storage[i + 1][j + 1] == '@')
                    neighbors++;
            if (storage[i + 1][j] == '@')
                neighbors++;
        }
        if(j - 1 >= 0)
            if (storage[i][j - 1] == '@')
                neighbors++;
        if(j + 1 < storage[0].length)
            if (storage[i][j + 1] == '@')
                neighbors++;
        return neighbors;
    }
}
