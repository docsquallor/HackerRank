import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static double during(double p, int n)
    {
        return 1 - Math.pow(1 - p , n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextInt();
        
        double p = a / b;
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(df.format(during(p, 5)));
        in.close();
    }
}
