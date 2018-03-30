import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < ar.length; i++)
        {
            if(ar[i] == max)
            {
                sum++;
            }
            else if(ar[i] > max)
            {
                sum = 1;
                max = ar[i];
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
