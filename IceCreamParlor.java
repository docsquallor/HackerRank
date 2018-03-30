import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] icecreamParlor(int m, int[] arr) {
        
        int[] original = new int[arr.length];
        System.arraycopy(arr, 0, original, 0, arr.length);
        
        Arrays.sort(arr);
        int i = 0 , j = arr.length - 1;
        
        while(true)
        {
            while(arr[i] + arr[j] > m)
            {
                j -= 1;
            }
            
            if(arr[i] + arr[j] == m)
            {
                int f;
                for(f = 0; arr[i] != original[f]; f++);
                i = f;
                for(f = 0; f == i || arr[j] != original[f]; f++);
                j = f;
                break;
            }
            else
            {
                i += 1;
            }
        }
        
        return new int[]{Math.min(i + 1, j + 1), Math.max(i + 1, j + 1)};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
