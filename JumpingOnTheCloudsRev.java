import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int jumpingOnClouds(int[] c, int k) {
        
        int thunderCount = (int)IntStream.range(0, c.length / k).filter(i -> c[i * k ] == 1).count();
        int jumps = c.length / k;
        
        return Math.max(0, 100 - thunderCount * 2 - jumps);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c, k);
        System.out.println(result);
        in.close();
    }
}
