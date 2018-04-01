import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Long> aMap = IntStream.of(arr).boxed().
            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> bMap = IntStream.of(brr).boxed().
            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return bMap.entrySet().stream().
            filter(e -> !e.getValue().equals(aMap.getOrDefault(e.getKey(), 0L))).
            mapToInt(Map.Entry :: getKey).sorted().toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
