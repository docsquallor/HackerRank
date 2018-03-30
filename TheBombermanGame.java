import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String[] bomberMan(int n, String[] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length();
        char[][] b = new char[rows][cols];
        char BOMB = 'O', NO_BOMB ='.';
        
        if(n <= 1)
        {
            return grid;
        }
        
        if(n == 2 || (n - 4) % 2 == 0)
        {
            IntStream.range(0, rows).forEach(i -> Arrays.fill(b[i], BOMB));
            IntStream.range(0, rows).forEach(i -> grid[i] = new String(b[i]));
            return grid;
        }
        
        Set<Integer> bombs= new HashSet<>();
        for(int i = 0; i < rows; i++)
        {
            char[] chars = grid[i].toCharArray();
            for(int j = 0; j < cols; j++)
            {
                if(chars[j] == BOMB)
                {
                    bombs.add(i * cols + j);
                }
            }
        }

        bombs = convolute(bombs, rows, cols, n);
        IntStream.range(0, rows).forEach(i -> Arrays.fill(b[i], NO_BOMB));
        bombs.forEach(o -> b[o / cols][o % cols] = BOMB);
        IntStream.range(0, rows).forEach(i -> grid[i] = new String(b[i]));
        return grid;
    }
    
    static Set<Integer> convolute(Set<Integer> bombs, int rows, int cols, int time)
    {
        int i = 0;
        Set<Integer> AB = IntStream.range(0, rows).
                                              flatMap(r -> IntStream.range(0, cols).map(c -> r * cols + c)).
                                              boxed().
                                              collect(Collectors.toSet());
        while(i <= (time - 3) % 4)
        {
            Set<Integer> allBombs = new HashSet<>(AB);
            
            bombs.parallelStream().forEach(b ->
            {
                int r = b / cols;
                int c = b % cols;                   
                allBombs.removeAll(Arrays.asList(
                    floor(r, c, rows, cols),
                    floor(r - 1, c, rows, cols),
                    floor(r + 1, c, rows, cols),
                    floor(r, c - 1, rows, cols),
                    floor(r, c + 1, rows, cols)));
            });
            
            bombs = allBombs;
            i += 2;
        }
        
        return bombs;
            
    }
    
    static int floor(int r, int c, int rows, int cols)
    {
        if(r >= 0 && r < rows && c >= 0 && c < cols)
        {
            return r * cols + c;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        String[] grid = new String[r];
        for(int grid_i = 0; grid_i < r; grid_i++){
            grid[grid_i] = in.next();
        }
        String[] result = bomberMan(n, grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
