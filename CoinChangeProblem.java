import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long getWays(int n, int[] c)
    {
        long[][] L = new long[n + 1][c.length + 1];
        
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= c.length; j++)
            {
                if(i == 0)
                {
                    L[i][j] = 1;
                }
                else if(j == 0)
                {
                    L[i][j] = 0;
                }
                else if(i >= c[j - 1])
                {
                    L[i][j] = L[i][j - 1] + L[i - c[j - 1]][j];
                }
                else
                {
                    L[i][j] = L[i][j - 1];
                }
            }
        }
        
        return L[n][c.length];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
