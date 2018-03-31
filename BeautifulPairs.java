import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long beautifulPairs(int[] A, int[] B) {
        Map<Integer, Long> aMap = IntStream.of(A).boxed().
            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> bMap = IntStream.of(B).boxed().
            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long total = aMap.entrySet().stream().
                        mapToLong(e -> Math.min(e.getValue(), bMap.getOrDefault(e.getKey(), 0L))).sum();
        return total == A.length ? total - 1 : total + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] B = new int[n];
        for(int B_i = 0; B_i < n; B_i++){
            B[B_i] = in.nextInt();
        }
        long result = beautifulPairs(A, B);
        System.out.println(result);
        in.close();
    }
}
