import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long stringConstruction(String s) {
       return s.chars().distinct().count();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            long result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }
}
