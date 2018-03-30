import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int twoCharacters(String s) {
        Map<Integer, Long> charMap = s.chars().boxed().
                                            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        Pattern alt = Pattern.compile("^([a-z])(?!\\1)([a-z])(?:\\1\\2)*\\1?$");        
        return charMap.entrySet().stream().
                flatMap(e -> charMap.entrySet().stream().
                    filter(f -> e != f).
                    map(f -> s.replaceAll(
                        "[^"+(char)(e.getKey().intValue())+""+(char)(f.getKey().intValue())+"]", "")
                       )).
                filter(alt.asPredicate()).
            map(String :: length).
            max(Integer :: compareTo).orElse(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharacters(s);
        System.out.println(result);
        in.close();
    }
}
