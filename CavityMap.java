import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static StringBuilder[] cavityMap(StringBuilder[] grid) {
        int[] flatMap = Stream.of(grid).flatMapToInt(r -> r.chars()).toArray();
        int r = grid.length;
        int c = grid[0].length();
        
        IntStream.range(1, r - 1).
            mapToObj(i -> IntStream.range(1, c - 1).
                         filter(j -> isMax(flatMap, i, j, c)).
                         mapToObj(j -> new AbstractMap.SimpleEntry<>(i, j))).
            forEach(s -> s.forEach(e -> grid[e.getKey()].setCharAt(e.getValue(), 'X')));
        return grid;
    }
    
    static boolean isMax(int[] flatMap, int i, int j, int c)
    {
        return !IntStream.of(-1, 0, 1).mapToObj(x -> IntStream.of(-1, 0, 1).
                                   filter(y -> x != y && x * y == 0).
                                   anyMatch(y -> flatMap[c * (i + x) + (j + y)] >= flatMap[c * i + j])).
                anyMatch(b -> b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder[] grid = new StringBuilder[n];
        for(int grid_i = 0; grid_i < n; grid_i++){
            grid[grid_i] = new StringBuilder(in.next());
        }
        StringBuilder[] result = cavityMap(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
