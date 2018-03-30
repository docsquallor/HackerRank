import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void plusMinus(int[] arr) {
        System.out.println((double)IntStream.of(arr).filter(i -> i > 0).count()/arr.length);
        System.out.println((double)IntStream.of(arr).filter(i -> i < 0).count()/arr.length);
        System.out.println((double)IntStream.of(arr).filter(i -> i == 0).count()/arr.length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
