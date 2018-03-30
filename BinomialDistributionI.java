import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long combination(int n, int x)
    {
        BigInteger nmxf = BigInteger.valueOf(n);
        BigInteger xf = BigInteger.valueOf(x == 0 ? n : x);
        
        for(int i = 1; i < x; i++)
        {
            nmxf = nmxf.multiply(BigInteger.valueOf(n - i));
            xf = xf.multiply(BigInteger.valueOf(i));
        }

        return nmxf.divide(xf).longValue();
    }
    
    static double atLeastX(int n, int x, double p)
    {
        double res = 0;
        for(int i = x; i <= n; i++)
        {
            res += combination(n, i) * Math.pow(p, i) * Math.pow(1 - p, n - i);
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double r1 = in.nextDouble();
        double r2 = in.nextDouble();
        
        double p1 = r1 / (r1 + r2);
        
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(df.format(atLeastX(6, 3, p1)));
        in.close();
    }
}
