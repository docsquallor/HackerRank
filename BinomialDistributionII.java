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
    
    static double between(int n, int x1, int x2, double p)
    {
        BigDecimal pbd = BigDecimal.valueOf(p);
        BigDecimal npbd = BigDecimal.valueOf(1 - p);
        
        BigDecimal res = BigDecimal.valueOf(0);
        BigDecimal pprime = pbd.pow(x1);
        BigDecimal npprime = BigDecimal.valueOf(1.0 - p).pow(n - x1);
        for(int i = x1; i <= x2; i++)
        {
            res = res.add(BigDecimal.valueOf(combination(n, i)).multiply(pprime).multiply(npprime));
            pprime = pprime.multiply(pbd);
            npprime = npprime.divide(npbd, MathContext.DECIMAL128);
        }
        
        return res.doubleValue();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double r = in.nextDouble();
        int n = in.nextInt();
        
        double p = r / 100;
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(df.format(between(n, 0, 2, p)));
        System.out.println(df.format(between(n, 2, n, p)));
        in.close();
    }
}
