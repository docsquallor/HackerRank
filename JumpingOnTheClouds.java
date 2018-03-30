import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int jumpingOnClouds(int[] c) {
        int i = 0;
        int jumps = 0;
        while(i != c.length - 1)
        {
            i += i + 2 < c.length && c[i + 2] == 0 ? 2 : 1;
            jumps += 1;
        }
        
        return jumps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        in.close();
    }
}
