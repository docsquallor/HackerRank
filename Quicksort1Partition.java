import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] quickSort(int[] arr) {
        int pivotIndex = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(i != pivotIndex && arr[i] <= arr[pivotIndex])
            {
                exchange(arr, pivotIndex + 1, i);
                exchange(arr, pivotIndex, pivotIndex + 1);
                pivotIndex = pivotIndex + 1;
                //printArray(arr);
            }
        }
       return arr;        
    }
    
    static void printArray(int[] result)
    {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
    }
    
    static void exchange(int[] arr, int i, int j)
    {
        if(i == j)
            return;
        
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = quickSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
