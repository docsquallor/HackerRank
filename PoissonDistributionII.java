import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double m1 = in.nextDouble();
        double m2 = in.nextDouble();
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(df.format(160.0 + 40 * (m1 + m1 * m1)));
        System.out.println(df.format(128.0 + 40 * (m2 + m2 * m2)));
        in.close();
    }
}
