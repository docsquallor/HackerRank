import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                                            t * ( 1.00002368 +
                                            t * ( 0.37409196 + 
                                            t * ( 0.09678418 + 
                                            t * (-0.18628806 + 
                                            t * ( 0.27886807 + 
                                            t * (-1.13520398 + 
                                            t * ( 1.48851587 + 
                                            t * (-0.82215223 + 
                                            t * ( 0.17087277))))))))));
        if (z >= 0) return  ans;
        else        return -ans;
    }

    static double Phi(double z) {
        return 0.5 * (1.0 + erf(z / (Math.sqrt(2.0))));
    }
    
    static double normalDist(double x, double mean, double stdev)
    {
        return Phi((x - mean) / stdev);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double mean = in.nextDouble();
        double stdev = in.nextDouble();
        double a = in.nextDouble();
        double l = in.nextDouble();
        double u = in.nextDouble();
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(df.format(normalDist(a, mean, stdev)));
        System.out.println(df.format(normalDist(u, mean, stdev) - normalDist(l, mean, stdev)));
        in.close();
    }
}
