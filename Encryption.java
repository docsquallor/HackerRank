import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String encryption(String s) {
        int R = (int)Math.floor(Math.sqrt(s.length()));
        int C = (int)Math.ceil(Math.sqrt(s.length()));
        
        StringBuffer e = new StringBuffer();
        
        for(int i = 0; i < C; i++)
        {
            for(int j = i; j < s.length(); j += C)
            {
                e.append(s.charAt(j));
            }
            e.append(' ');
        }
        
        return e.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = encryption(s);
        System.out.println(result);
        in.close();
    }
}
