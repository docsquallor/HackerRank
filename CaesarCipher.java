import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String caesarCipher(String s, int k) {
        return s.chars().
                map(c -> c >= 'A' && c <= 'Z' ? 
                        'A' + (c - 'A' + k) % 26 : 
                            c >= 'a' && c <= 'z' ? 
                            'a' + (c - 'a' + k) % 26 : 
                        c).
                mapToObj(i -> String.valueOf((char)i)).reduce("", String :: concat);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }
}
