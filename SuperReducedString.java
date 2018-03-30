import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String super_reduced_string(String s){
        String reduced = reduce(s);
        while(!s.equals(reduced))
        {
            s = reduced;
            reduced = reduce(s);
        }
        return reduced.isEmpty() ? "Empty String" : reduced;
    }

    static String reduce(String s)
    {
        s = s + "#";
        AtomicInteger acc = new AtomicInteger(-1);
        return s.chars().map(c -> c == acc.get() ? acc.updateAndGet(x -> -1) : acc.getAndSet(c)).
                        filter(c -> c != -1).mapToObj(c -> Character.toString((char)c)).reduce("", String :: concat);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
