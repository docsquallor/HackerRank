import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int equal(int[] arr) {
        int min = IntStream.of(arr).min().orElse(0);
        return IntStream.rangeClosed(0, 4).
            map(x -> IntStream.of(arr).map(i -> toZero(i - min + x)).sum()).min().orElse(0);
    }
    
    static int toZero(int i)
    {
        return (i / 5) + ((i % 5) / 2) + ((i % 5) % 2);
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
            int result = equal(arr);
            System.out.println(result);
        }
        in.close();
    }
}
