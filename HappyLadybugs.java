import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.regex.*;

public class Solution {

    static String happyLadybugs(String b) {
        if(b.chars().filter(c -> c != '_').boxed().
           collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
           values().contains(1L))
        {
            return "NO";
        }
        
        if(b.indexOf('_') != -1)
        {
            return "YES";
        }
        
        char[] chars = b.toCharArray();
        return chars[0] == chars[1] && 
               !IntStream.range(1, chars.length - 1).
                            anyMatch(i -> chars[i] != chars[i - 1] && chars[i] != chars[i + 1]) &&
               chars[chars.length - 2] == chars[chars.length - 1] ? "YES" : "NO";
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
