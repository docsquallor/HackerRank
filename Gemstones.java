import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int gemstones(String[] arr){
        Set<Integer> reduced = arr[0].chars().boxed().collect(Collectors.toSet());
        Stream.of(arr).map(m -> m.chars().boxed().collect(Collectors.toSet())).
                forEach(reduced :: retainAll);
        return reduced.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }
}
