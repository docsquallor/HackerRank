import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long[] cutTheSticks(int[] arr) {
        TreeMap<Integer, Long> sticks = new TreeMap<>(IntStream.of(arr).boxed().
                                            collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        AtomicLong ai = new AtomicLong(arr.length);
        return sticks.values().stream().mapToLong(i -> ai.getAndAccumulate(i, (a, b) -> a - b)).toArray();   
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long[] result = cutTheSticks(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
