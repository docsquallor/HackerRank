import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int connectedCell(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Map<Integer, Set<Integer>> adjacencyMap = IntStream.range(0, n * m).boxed().
            collect(Collectors.toMap(Function.identity(), HashSet :: new));
        
        Map<Integer, Integer> indexMap = IntStream.range(0, n * m).boxed().
            collect(Collectors.toMap(Function.identity(), Function.identity()));
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                conditionalConnect(matrix, adjacencyMap, indexMap, i, j, i - 1, j);
                conditionalConnect(matrix, adjacencyMap, indexMap, i, j, i, j - 1);
                conditionalConnect(matrix, adjacencyMap, indexMap, i, j, i - 1, j - 1);
                conditionalConnect(matrix, adjacencyMap, indexMap, i, j, i + 1, j);
                conditionalConnect(matrix, adjacencyMap, indexMap, i, j, i, j + 1);
                conditionalConnect(matrix, adjacencyMap, indexMap, i, j, i + 1, j + 1);
                conditionalConnect(matrix, adjacencyMap, indexMap, i, j, i - 1, j + 1);
                conditionalConnect(matrix, adjacencyMap, indexMap, i, j, i + 1, j - 1);
            }
        }  
        
        return adjacencyMap.values().stream().mapToInt(Set::size).max().orElse(-1) + 1;
    }
    
        
    static void conditionalConnect(int[][] matrix, 
                                   Map<Integer, Set<Integer>> adjacencyMap, 
                                   Map<Integer, Integer> indexMap, 
                                   int i1, int j1, int i2, int j2)
    {
        if(get(matrix, i1, j1) == 1 && get(matrix, i2, j2) == 1)
        {
            connect(adjacencyMap, indexMap, i1 * matrix[0].length + j1, i2 * matrix[0].length + j2);
        }
    }
        
    static int get(int[][] matrix, int i, int j)
    {
        if(i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length)
        {
            return matrix[i][j];
        }
        
        return 0;
    }

    static void connect(Map<Integer, Set<Integer>> adjacencyMap, Map<Integer, Integer> indexMap, int x, int y)
    {
        int xindex = indexMap.get(x);
        int yindex = indexMap.get(y);
        
        if(xindex != yindex)
        {
            int from = Math.max(xindex, yindex);
            int to = Math.min(xindex, yindex);
            
            adjacencyMap.get(to).add(from);
            indexMap.put(from, to);
            
            adjacencyMap.get(to).addAll(adjacencyMap.get(from));
            adjacencyMap.get(from).forEach(i -> indexMap.put(i, to));
            
            adjacencyMap.remove(from);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for(int matrix_i = 0; matrix_i < n; matrix_i++){
            for(int matrix_j = 0; matrix_j < m; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        int result = connectedCell(matrix);
        System.out.println(result);
        in.close();
    }
}
