import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int commonChild(String s1, String s2){
        return maxChild(s1.toCharArray(), s2.toCharArray());
    }
    
    static int maxChild(char[] s1, char[] s2)
    {
        int[][] L = new int[s1.length + 1][s2.length + 1];
        
        for(int i = 0; i <= s1.length; i++)
        {
            for(int j = 0; j <= s2.length; j++)
            {
                if(i == 0 || j == 0)
                {
                    L[i][j] = 0;
                }
                else if(s1[i - 1] == s2[j - 1])
                {
                    L[i][j] = L[i - 1][j - 1] + 1;
                }
                else
                {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        
        return L[s1.length][s2.length];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}
