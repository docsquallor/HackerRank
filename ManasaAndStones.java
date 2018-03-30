import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] stones(int n, int a, int b) {
        return IntStream.rangeClosed(0, n - 1).
            map(x -> x * Math.max(a, b) + (n - 1 - x) * Math.min(a, b)).
            distinct().
            toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int[] result = stones(n, a, b);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
