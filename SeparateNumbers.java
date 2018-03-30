import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void separateNumbers(String s) {
        OptionalInt i = IntStream.range(1, Math.min(17, s.length() - 1)).
                        filter(x -> isBeautiful(s, s.substring(0, x))).
                        findAny();
        System.out.println(i.isPresent() ? "YES "+s.substring(0, i.getAsInt()) : "NO");
        
    }
    
    static boolean isBeautiful(String s, String num)
    {
        return s.isEmpty() || 
            (s.startsWith(num) && 
            isBeautiful(s.substring(num.length()), Long.toString(Long.parseLong(num) + 1)));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            separateNumbers(s);
        }
        in.close();
    }
}
