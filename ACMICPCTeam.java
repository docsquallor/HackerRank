import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long[] acmTeam(String[] topic) {
        TreeMap<Integer, Long> frequencies = new TreeMap<>(
                                            IntStream.range(0, topic.length).
                                            flatMap(i -> IntStream.range(i + 1, topic.length).
                                                    map(j -> IntStream.range(0, topic[i].length()).
                                                    reduce(0, (a, b) -> 
                                                           a + ((topic[i].charAt(b) == '1' || 
                                                                topic[j].charAt(b) == '1') ? 1 : 0)))).
                                            boxed().
                                            collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        Map.Entry<Integer, Long> max = frequencies.pollLastEntry();
        return new long[]{max.getKey(), max.getValue()};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] topic = new String[n];
        for(int topic_i = 0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        long[] result = acmTeam(topic);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
