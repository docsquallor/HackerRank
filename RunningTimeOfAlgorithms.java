import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int runningTime(int[] arr) {
        int totalShifts = 0;
        for(int i = 1; i < arr.length; i++)
        {
            int value = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > value)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
                totalShifts++;
            }
            arr[j + 1] = value;
        }
        return totalShifts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = runningTime(arr);
        System.out.println(result);
        in.close();
    }
}
