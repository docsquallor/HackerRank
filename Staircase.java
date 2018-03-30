import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void staircase(int n) {
        StringBuffer sbuf = new StringBuffer();
        IntStream.range(0, n).forEach(i -> sbuf.append(" "));
        for(int i = 1; i <= n; i++)
        {
            sbuf.setCharAt(n - i, '#');
            System.out.println(sbuf);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}
