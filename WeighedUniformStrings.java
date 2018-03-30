import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.regex.*;

public class Solution {

    static String[] weightedUniformStrings(String s, int[] queries) {
        Pattern rep = Pattern.compile("(.)(:?\\1*)");
        Matcher mat = rep.matcher(s);
        Set<Integer> q = new HashSet<>();
        while(mat.find())
        {
            AtomicInteger acc = new AtomicInteger(0);
            q.addAll(mat.group().chars().
                     map(c -> acc.updateAndGet(x -> x + c - 'a' + 1)).boxed().collect(Collectors.toSet()));
        }
        return IntStream.of(queries).mapToObj(x -> q.contains(x) ? "Yes" : "No").toArray(String[] :: new);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(result[resultItr]);

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
