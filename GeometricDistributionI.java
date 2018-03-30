import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static double at(double p, int n)
    {
        return Math.pow(1 - p , n - 1)* p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextInt();
        
        double p = a / b;
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(df.format(at(p, 5)));
        in.close();
    }
}
