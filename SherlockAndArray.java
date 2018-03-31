import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int[] a){
        int n = a.length;
        int[][] s = new int[n][2];
        IntStream.range(0, a.length).forEach(i -> {
            s[i][0] = i == 0 ? a[0] : s[i - 1][0] + a[i];
            s[n - 1 - i][1] = i == 0 ? a[n - 1] : s[n - i][1] + a[n - i - 1];
        });
        return IntStream.range(0, n).anyMatch(i -> s[i][0] == s[i][1]) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}
