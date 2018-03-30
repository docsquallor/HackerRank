import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int mst(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> weightForest = IntStream.rangeClosed(1, n).boxed().
                                                                     collect(Collectors.toMap(k -> k, HashMap :: new));

        Map<Integer, Integer> indices = IntStream.rangeClosed(1, n).boxed().
                                                  collect(Collectors.toMap(k -> k, v -> v));
        
        Arrays.sort(edges, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return a[2] - b[2];
            }
        });
        
        int i = 0;
        while(weightForest.size() > 1 && i < edges.length)
        {
            connect(weightForest, indices, edges[i][0], edges[i][1], edges[i][2]);
            i += 1;
        }
        
        if(weightForest.size() > 1)
        {
            return -1;
        }
        
        return weightForest.get(1).values().stream().mapToInt(Integer::valueOf).sum();
    }
    
    static void connect(Map<Integer, Map<Integer, Integer>> weightForest, 
                        Map<Integer, Integer> indices, 
                        int i, 
                        int j, 
                        int w)
    {
        int indexI = indices.get(i);
        int indexJ = indices.get(j);
        
        if(indexI != indexJ)
        {
            int from = Math.max(indexI, indexJ);
            int to = Math.min(indexI, indexJ);
            
            weightForest.get(to).put(from, w);
            weightForest.get(to).putAll(weightForest.get(from));
            
            indices.put(from, to);
            weightForest.get(from).keySet().stream().forEach(f -> indices.put(f, to));
            
            weightForest.remove(from);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] edges = new int[m][3];
        for(int edges_i = 0; edges_i < m; edges_i++){
            for(int edges_j = 0; edges_j < 3; edges_j++){
                edges[edges_i][edges_j] = in.nextInt();
            }
        }
        int result = mst(n, edges);
        System.out.println(result);
        in.close();
    }
}
