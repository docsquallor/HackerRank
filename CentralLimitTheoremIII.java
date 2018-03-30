import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        double mean = in.nextDouble();
        double stdev = in.nextDouble();
        double p = in.nextDouble();
        double zscore = in.nextDouble();
        
        double nStdev = stdev / Math.sqrt(n);
        
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println(df.format(mean - zscore* nStdev));
        System.out.println(df.format(mean + zscore * nStdev));
        in.close();
    }
}
