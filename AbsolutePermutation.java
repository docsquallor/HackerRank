import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long strangeCode(long t) {
        long current = 3;
        while(t > current)
        {
            t -= current;
            current = current << 1;
        }
        
        return current + 1 - t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        long result = strangeCode(t);
        System.out.println(result);
        in.close();
    }
}
