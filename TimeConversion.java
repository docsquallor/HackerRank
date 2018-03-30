import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String timeConversion(String s) {
        if(s.matches("^.*AM"))
        {
            return String.format("%02d", Integer.parseInt(s.substring(0,2)) % 12) + s.substring(2, s.length() - 2);
        }
        else
        {
            return (12 + Integer.parseInt(s.substring(0,2)) % 12) + s.substring(2, s.length() - 2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
