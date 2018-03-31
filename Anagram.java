import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long anagram(String s){
        if(s.length() % 2 == 1)
        {
            return -1;
        }

        Set<Integer> allChars = s.chars().boxed().collect(Collectors.toSet());
        Map<Integer, Long> loMap = s.substring(0, s.length() / 2).chars().boxed().
            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> hiMap = s.substring(s.length() / 2, s.length()).chars().boxed().
            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return  allChars.stream().
                map(c -> Optional.ofNullable(hiMap.get(c)).orElse(0L) - Optional.ofNullable(loMap.get(c)).orElse(0L)).
                mapToLong(Math :: abs).sum() / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            long result = anagram(s);
            System.out.println(result);
        }
    }
}
