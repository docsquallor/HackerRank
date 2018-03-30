import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    

    public static int[] minDistance(int n, int m, int[][] edges, int s)
    {
        Map<Integer, Map<Integer, Integer>> minEdgeSimpleGraph = IntStream.rangeClosed(1, n).
            boxed().
            collect(Collectors.toMap(k -> k, HashMap :: new));
        
        for(int[] edge : edges)
        {
            if(Optional.ofNullable(minEdgeSimpleGraph.get(edge[0]).get(edge[1])).map(w -> w > edge[2]).orElse(true))
            {
                minEdgeSimpleGraph.get(edge[0]).put(edge[1], edge[2]);
                minEdgeSimpleGraph.get(edge[1]).put(edge[0], edge[2]);
            }
        }
        
        Map<Integer, Integer> costMap = IntStream.rangeClosed(1, n).
                                                boxed().
                                                collect(Collectors.toMap(k -> k, v -> Integer.MAX_VALUE));
        
        boolean[] visited = new boolean[n];
        int current = s;
        costMap.put(s, 0);
        
        while(current != -1)
        {
            visited[current - 1] = true;
            for(Map.Entry<Integer, Integer> edge : minEdgeSimpleGraph.get(current).entrySet())
            {
                costMap.put(edge.getKey(), Math.min(costMap.get(edge.getKey()), costMap.get(current) + edge.getValue()));
            }
            
            current = costMap.entrySet().stream().
                filter(e -> !visited[e.getKey() -1] && e.getValue() != Integer.MAX_VALUE).
                min((e1, e2) -> e1.getValue() - e2.getValue()).
                map(Map.Entry :: getKey).
                orElse(-1);
        }
            
        return IntStream.rangeClosed(1, n).
            filter(i -> i != s).
            map(i -> costMap.get(i)).
            map(w -> (w == Integer.MAX_VALUE ? -1 : w)).
            toArray();
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int a0 = 0; a0 < t; a0++){
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][] edges = new int[m][3];
            for(int a1 = 0; a1 < m; a1++){
                String[] edge012 = br.readLine().split(" ");
                edges[a1][0] = Integer.parseInt(edge012[0]);
                edges[a1][1] = Integer.parseInt(edge012[1]);
                edges[a1][2] = Integer.parseInt(edge012[2]);
            }
            int s = Integer.parseInt(br.readLine());
            
            int[] minDist = minDistance(n, m, edges, s);
            for(int i = 0; i < minDist.length; i++)
            {
                if(i == minDist.length - 1)
                {
                    System.out.println(minDist[i]);
                }
                else
                {
                    System.out.print(minDist[i]+" ");
                }
            }
        }
    }
}
