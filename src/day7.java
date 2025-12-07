import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class day7 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("./src/input1.in").toPath());

        int width = lines.getFirst().length();
        long[] timelines = new long[width];
        int startIndex = lines.getFirst().indexOf("S");

        lines.removeFirst();
        timelines[startIndex] = 1;
        long totalTimelines = 0;
        while (!lines.isEmpty()) {
            String row = lines.getFirst();
            long[] next = new long[width];
            for (int i = 0; i < width; i++) {
                long count = timelines[i];
                if (count == 0) continue;

                if (row.charAt(i) == '^') {
                    if (i - 1 >= 0)
                        next[i - 1] += count;
                    else
                        totalTimelines += count;
                    if (i + 1 < width)
                        next[i + 1] += count;
                    else
                        totalTimelines += count;
                } else {
                    next[i] += count;
                }
            }
            timelines = next;
            lines.removeFirst();
        }
        for (int i = 0; i < width; i++) {
            totalTimelines += timelines[i];
        }
        System.out.println(totalTimelines);
    }
}
