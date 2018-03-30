import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.atomic.*;

public class Solution {

    static int getTotalX(int[] a, int[] b) {
        int min = IntStream.of(a).max().getAsInt();
        int max = IntStream.of(b).min().getAsInt();
        AtomicInteger supplier = new AtomicInteger(0);
        return (int) IntStream.generate(() -> supplier.addAndGet(min)).
            limit((max - min)/min + 1).
            mapToObj(i -> IntStream.of(a).mapToObj(j -> i % j == 0).anyMatch(p -> !p)
                        || IntStream.of(b).mapToObj(j -> j % i == 0).anyMatch(p -> !p)).filter(p -> !p).count();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
