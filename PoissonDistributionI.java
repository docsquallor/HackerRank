import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static double poisson(double mean, long k)
    {
        return ((Math.pow(Math.E, -mean) * Math.pow(mean, k)) / LongStream.rangeClosed(1, k).reduce((a, b) -> a * b).orElse(1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double mean = in.nextDouble();
        long n = in.nextLong();
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(df.format(poisson(mean, n)));
        in.close();
    }
}
