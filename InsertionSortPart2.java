import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void insertionSort2(int n, int[] arr) {
        for(int i = 1 ; i < arr.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[i] <= arr[j])
                {
                    int dangling = arr[j];
                    int index = j;
                    arr[index++] = arr[i];
                    while(index <= i)
                    {
                        arr[index] = dangling + arr[index];
                        dangling = arr[index] - dangling;
                        arr[index] = arr[index] - dangling;
                        index++;
                    }
                }
            }
            
            for(int p = 0; p < arr.length; p++)
            {
                System.out.print(arr[p]);
                System.out.print(p == arr.length - 1 ? "" : " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort2(n, arr);
        in.close();
    }
}
