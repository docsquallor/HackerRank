import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] bfs(int n, int m, int[][] edges, int s) {
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        IntStream.rangeClosed(1, n).forEach(i -> adjacencyMap.put(i, new HashSet<>()));
        IntStream.range(0, m).forEach(i -> 
                                      {
                                          adjacencyMap.get(edges[i][0]).add(edges[i][1]);
                                          adjacencyMap.get(edges[i][1]).add(edges[i][0]);
                                      });
        Map<Integer, Integer> pathLengths = bfs(adjacencyMap, s);
        return IntStream.rangeClosed(1, n).
                        filter(i -> i != s).
                        map(i -> Optional.ofNullable(pathLengths.get(i)).orElse(-1)).
                        toArray();
    }
    
    static Map<Integer, Integer> bfs(Map<Integer, Set<Integer>> adjacencyMap, int index)
    {
        Set<Integer> explored = new HashSet<>();
        List<Integer> expand = new ArrayList<>();
        Map<Integer, Integer> pathLengths = new TreeMap<>();
        
        expand.add(index);
        pathLengths.put(index, 0);
        while(expand.size() != 0 && explored.size() != adjacencyMap.size())
        {
            explored.addAll(expand);
            int e = expand.get(0);
            expand.remove(0);
            
            HashSet<Integer> nextExpansion = new HashSet<>(adjacencyMap.get(e));
            nextExpansion.removeAll(explored);
            expand.addAll(nextExpansion);
            pathLengths.putAll(nextExpansion.stream().collect(Collectors.toMap(k -> k, v -> pathLengths.get(e) + 6)));
        }
        
        return pathLengths;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][2];
            for(int edges_i = 0; edges_i < m; edges_i++){
                for(int edges_j = 0; edges_j < 2; edges_j++){
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }
            int s = in.nextInt();
            int[] result = bfs(n, m, edges, s);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
