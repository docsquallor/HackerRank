import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String twoStrings(String s1, String s2){
        Set<Integer> s1Chars = s1.chars().boxed().collect(Collectors.toSet());
        Set<Integer> s2Chars = s2.chars().boxed().collect(Collectors.toSet());
        s1Chars.retainAll(s2Chars);
        return s1Chars.size() > 0 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }
}
