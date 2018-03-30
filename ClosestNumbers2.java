import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void closestNumbers(int[] arr) {
        Arrays.sort(arr);
        int min = IntStream.range(0, arr.length - 1).
            map(i -> arr[i + 1] - arr[i]).min().orElse(Integer.MAX_VALUE);
        IntStream.range(0, arr.length - 1).
            filter(i -> arr[i + 1] - arr[i] == min).
            forEach(i -> System.out.print(arr[i]+" "+arr[i + 1]+" "));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        closestNumbers(arr);
        System.out.println("");


        in.close();
    }
}
