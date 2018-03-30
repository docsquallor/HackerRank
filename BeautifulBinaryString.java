import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int beautifulBinaryString(String b) {
        if(b.indexOf("010") == 0)
        {
            StringBuilder bprime = new StringBuilder(b);
            bprime.setCharAt(2, '1');
            return 1 + beautifulBinaryString(bprime.substring(1));
        }
        
        return b.length() < 3 ? 0 : beautifulBinaryString(b.substring(1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String b = in.next();
        int result = beautifulBinaryString(b);
        System.out.println(result);
        in.close();
    }
}
