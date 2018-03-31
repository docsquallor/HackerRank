import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String gridChallenge(String[] grid) {
        int cols = grid[0].length();
        int[] charMap = Stream.of(grid).flatMapToInt(r -> r.chars().sorted()).toArray();
        return IntStream.range(0, cols).
            anyMatch(i -> IntStream.range(0, grid.length - 1).
                     anyMatch(j -> charMap[i + j * cols] > charMap[i + (j + 1)* cols])) ? "NO" : "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int test = 0; test < t; test++)
        {
            int n = in.nextInt();
            String[] grid = new String[n];
            for(int grid_i = 0; grid_i < n; grid_i++){
                grid[grid_i] = in.next();
            }
            String result = gridChallenge(grid);
            System.out.println(result);
        }
        in.close();
    }
}
