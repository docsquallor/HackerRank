import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void extraLongFactorials(int n) {
        BigInteger bi = BigInteger.ONE;
        for(int i = 2; i <= n ; i++)
        {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bi.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
