import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int lonelyinteger(int[] a) {
        return IntStream.of(a).reduce((x, y) -> x ^ y).orElse(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = lonelyinteger(a);
        System.out.println(result);
    }
}
