import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long MOD = (long)(Math.pow(10, 9) + 7);
    static long seriesSum(long n) {
        BigInteger bi = BigInteger.valueOf(n);
        return bi.modPow(BigInteger.valueOf(2), BigInteger.valueOf(MOD)).longValue();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long result = seriesSum(n);
            System.out.println(result);
        }
        in.close();
    }
}
