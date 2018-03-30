import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int cost(int[] arr) {
        int[][] L = new int[arr.length][2];
        
        for(int i = 1; i < arr.length; i++)
        {
            L[i][0] = Math.max(L[i - 1][0], L[i - 1][1] + (arr[i - 1] - 1));
            L[i][1] = Math.max(L[i - 1][0] + (arr[i] - 1), L[i - 1][1] + Math.abs(arr[i] - arr[i - 1]));
        }
        
        return Math.max(L[arr.length - 1][0], L[arr.length - 1][1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = cost(arr);
            System.out.println(result);
        }
        in.close();
    }
}
