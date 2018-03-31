import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] largestPermutation(int k, int[] arr, int[] inv, int index) {
        if(k == 0 || index == arr.length)
        {
            return arr;
        }
        
        if(arr[index] != arr.length - index)
        {
            inv[arr[arr.length - n]] = inv[n];
            arr[inv[n]] = arr[arr.length - n];
            arr[arr.length - n] = n;
            k -= 1;
        }
        
        return largestPermutation(k, arr, inv, index + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] inv = new int[arr.length + 1];
        IntStream.range(0, arr.length).forEach(i -> inv[arr[i]] = i);
        int[] result = largestPermutation(k, arr, inv, 0);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
