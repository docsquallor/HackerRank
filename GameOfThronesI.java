import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String gameOfThrones(String s){
        return s.chars().boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                values().stream().filter(v -> v % 2 == 1).count() <= 1 ? "YES" : "NO"; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}
