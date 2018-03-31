import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        return IntStream.range(0, A.length).anyMatch(i -> A[i] + B[B.length - 1 - i] < k) ? "NO" : "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] A = new int[n];
            for(int A_i = 0; A_i < n; A_i++){
                A[A_i] = in.nextInt();
            }
            int[] B = new int[n];
            for(int B_i = 0; B_i < n; B_i++){
                B[B_i] = in.nextInt();
            }
            String result = twoArrays(k, A, B);
            System.out.println(result);
        }
        in.close();
    }
}
