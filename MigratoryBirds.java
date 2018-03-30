import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int migratoryBirds(int n, int[] ar) {
        return IntStream.of(ar).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
            entrySet().stream().sorted((a, b) -> (int)(b.getValue() - a.getValue())).
            findFirst().map(Map.Entry::getKey).orElse(-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
