import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static boolean appendAndDelete(String s, String t, int k) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        
        OptionalInt index = IntStream.range(0, Math.min(cs.length, ct.length)).
                                    filter(i -> cs[i] != ct[i]).
                                    findFirst();

        int result =  (index.isPresent() ? cs.length + ct.length - 2 * index.getAsInt() :
                            Math.max(cs.length, ct.length) - Math.min(cs.length, ct.length));
        
        if(result > k)
        {
            return false;
        }
        else if(index.isPresent())
        {
            return (k - result) % 2 == 0 || (k - result) >= (index.getAsInt() + 1) * 2;
        }
        else
        {
            return (k - result) % 2 == 0 || (k - result) >= Math.min(cs.length, ct.length) * 2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        System.out.println(appendAndDelete(s, t, k) ? "Yes" : "No");
        in.close();
    }
}
