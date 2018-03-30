import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String funnyString(String s){
        StringBuilder reverse = new StringBuilder(s).reverse();
        return IntStream.range(0, s.length() - 1).
            anyMatch(i -> Math.abs(s.charAt(i + 1) - s.charAt(i)) != 
                     Math.abs(reverse.charAt(i + 1) - reverse.charAt(i))) ?
            "Not Funny" : "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}
