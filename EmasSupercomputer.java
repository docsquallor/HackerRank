import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int twoPluses(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        char[][] G = new char[rows][cols];
            
        for(int i = 0; i < rows; i++)
        {
            G[i] = grid[i].toCharArray();
        }
        
        return maxArea(G);
    }
    
    static int maxArea(char[][] grid)
    {
        Set<Set<Integer>> allMax = new HashSet<>();
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                int plusLength = 1;
                Set<Integer> plusPoints;
                while((plusPoints = getValidPlus(grid, i, j, plusLength)) != null)
                {
                   allMax.add(plusPoints);
                   plusLength++;
                }               
            }
        }

        return allMax.stream().
            flatMapToInt(p0 -> allMax.stream().mapToInt(p1 -> Collections.disjoint(p0, p1) ? p0.size() * p1.size() : 0)).
            max().orElse(0);
    }
    
    static Set<Integer> getValidPlus(char[][] grid, int i, int j, int len)
    {
        char GOOD = 'G';
        Set<Integer> plusPoints = new HashSet<>();
        for(int l = 0; l < len; l++)
        {
            if(i - l >= 0 && i + l < grid.length && j - l >= 0 && j + l < grid[0].length 
               && grid[i][j - l] == GOOD && grid[i][j + l] == GOOD && grid[i - l][j] == GOOD && grid[i + l][j] == GOOD)
            {
                plusPoints.add(grid[0].length * (i) + j - l);
                plusPoints.add(grid[0].length * (i) + j + l);
                plusPoints.add(grid[0].length * (i + l) + j);
                plusPoints.add(grid[0].length * (i - l) + j);
            }
            else
            {
                return null;
            }
        }
        
        return plusPoints;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i = 0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        int result = twoPluses(grid);
        System.out.println(result);
        in.close();
    }
}
