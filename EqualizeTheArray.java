import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long equalizeArray(int[] arr) {
        return arr.length - IntStream.of(arr).boxed().
                            collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                            values().stream().mapToLong(Long :: valueOf).max().orElse(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long result = equalizeArray(arr);
        System.out.println(result);
        in.close();
    }
}
