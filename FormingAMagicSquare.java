import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
   
    static int formingMagicSquare(int[][] s) {      
        
        int[][] seed = new int[][]{{4, 9, 2},
                                   {3, 5, 7},
                                   {8, 1 ,6}};
        
        int min = Math.min(Integer.MAX_VALUE, diff(seed, s));
        reflect(seed, true);
        min = Math.min(min, diff(seed, s));
        reflect(seed, false);
        min = Math.min(min, diff(seed, s));
        reflect(seed, true);
        min = Math.min(min, diff(seed, s));
        
        reflect(seed, false); // original
        rotate(seed);
        
        min = Math.min(min, diff(seed, s));
        reflect(seed, true);
        min = Math.min(min, diff(seed, s));
        reflect(seed, false);
        min = Math.min(min, diff(seed, s));
        reflect(seed, true);
        min = Math.min(min, diff(seed, s));
        
        return min;
    }
    
    static int diff(int[][] a, int[][] b)
    {
        int diff = 0;
         for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a.length; j++)
            {
                diff += Math.abs(a[i][j] - b[i][j]);
            }
         }
        
        return diff;
    }
    
    static void reflect(int[][] s, boolean iAxis)
    {
        for(int i = 0; i < s.length / (iAxis ? 2 : 1); i++)
        {
            for(int j = 0; j < s.length / (iAxis ? 1 : 2); j++)
            {
                if(iAxis)
                {
                    int temp = s[i][j];
                    s[i][j] = s[s.length - 1 - i][j];
                    s[s.length - 1 - i][j] = temp;
                }
                else
                {
                    int temp = s[i][j];
                    s[i][j] = s[i][s.length - 1 - j];
                    s[i][s.length - 1 - j] = temp;
                }
            }
        }
    }
    
    static void rotate(int[][] s)
    {
        int N = s.length;
        for (int x = 0; x < N / 2; x++)
        {
            for (int y = x; y < N-x-1; y++)
            {
                int temp = s[x][y];
                s[x][y] = s[y][N-1-x];
                s[y][N-1-x] = s[N-1-x][N-1-y];
                s[N-1-x][N-1-y] = s[N-1-y][x];
                s[N-1-y][x] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}
