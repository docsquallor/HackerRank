import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Solution {

    static String pangrams(String s) {
        return s.toLowerCase().chars().
            filter(c -> c >= 'a' && c <= 'z').boxed().
            collect(Collectors.toSet()).size() == 26 ?
            "pangram" : "not pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
