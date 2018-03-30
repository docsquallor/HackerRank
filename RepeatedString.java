import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long repeatedString(String s, long n) {
        AtomicInteger acc = new AtomicInteger(0);        
        int[] cumFreq = s.chars().map(c -> c == 'a' ? acc.incrementAndGet() : acc.get()).toArray();
        int offset = (int)(n % s.length()) - 1;
        return cumFreq[s.length() - 1] * (n / s.length()) + (offset == -1 ? 0 : cumFreq[offset]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long result = repeatedString(s, n);
        System.out.println(result);
        in.close();
    }
}
