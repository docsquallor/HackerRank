import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int toys(int[] w) {
        SortedSet<Integer> sorted = IntStream.of(w).boxed().collect(Collectors.toCollection(TreeSet :: new));
        Integer next;
        int count = 0;
        while(!sorted.isEmpty())
        {
            next = sorted.first();
            sorted = sorted.tailSet(next + 5);
            count += 1;
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        for(int w_i = 0; w_i < n; w_i++){
            w[w_i] = in.nextInt();
        }
        int result = toys(w);
        System.out.println(result);
        in.close();
    }
}
