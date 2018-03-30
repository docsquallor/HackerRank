import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int pairs(int k, int[] arr) {
        Map<Integer, Long> sorted = IntStream.of(arr).boxed().
                                    collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));        
        return IntStream.of(arr).map(i -> Optional.ofNullable(sorted.get(i + k)).map(Long::intValue).orElse(0)).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        in.close();
    }
}
