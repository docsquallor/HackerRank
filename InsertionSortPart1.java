import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void insertionSort1(int n, int[] arr) {
        int var = arr[arr.length - 1];
        int i = arr.length - 2;
        for(; i >= 0 && var <= arr[i]; i--)
        {
            arr[i + 1] = arr[i];
            printArray(arr);
        }
        arr[i + 1] = var;
        printArray(arr);
    }
    
    static void printArray(int[] arr)
    {
        StringBuilder printer = new StringBuilder();
        IntStream.of(arr).mapToObj(Integer :: toString).forEach(s -> printer.append(s+" "));
        System.out.println(printer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }
}
