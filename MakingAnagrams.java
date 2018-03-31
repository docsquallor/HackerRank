import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long makingAnagrams(String s1, String s2){
        Set<Integer> allChars = (s1 + s2).chars().boxed().collect(Collectors.toSet());
        Map<Integer, Long> s1Map = s1.chars().boxed().
            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> s2Map = s2.chars().boxed().
            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return allChars.stream().mapToLong(c -> s1Map.getOrDefault(c, 0L) - s2Map.getOrDefault(c, 0L)).
                map(Math :: abs).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        long result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
