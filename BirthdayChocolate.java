import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.atomic.*;

public class Solution {

    static int solve(int n, int[] s, int d, int m){
        AtomicInteger trailIndex = new AtomicInteger(-1);
        AtomicInteger headSum = new AtomicInteger(IntStream.of(s).limit(m).sum());
        int init = headSum.intValue() == d ? 1 : 0;
        return (int)IntStream.of(s).skip(m).filter(i -> headSum.addAndGet(i - s[trailIndex.incrementAndGet()]) == d).count() + init;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
