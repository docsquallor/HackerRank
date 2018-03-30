import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long camelcase(String s) {
        return s.chars().filter(i -> i >= 'A' && i <= 'Z').count() + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}
