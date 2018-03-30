import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] x = IntStream.range(0, n).mapToDouble(i -> in.nextDouble()).toArray();
        double[] y = IntStream.range(0, n).mapToDouble(i -> in.nextDouble()).toArray();
        
        double ux = DoubleStream.of(x).sum() / n;
        double uy = DoubleStream.of(y).sum() / n;
        
        double stdevx = Math.sqrt(DoubleStream.of(x).map(d -> Math.pow(d - ux, 2)).sum() / n);
        double stdevy = Math.sqrt(DoubleStream.of(y).map(d -> Math.pow(d - uy, 2)).sum() / n);
        
        
        double rxy = IntStream.range(0, n).mapToDouble(i -> (x[i] - ux) * (y[i] - uy)).sum() / (n * stdevx * stdevy);
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(df.format(rxy));
        in.close();
    }
}
