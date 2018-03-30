import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        Map<Integer, Set<Integer>> connections = new HashMap<>();
        Map<Integer, Integer> redirects = new HashMap<>();
        IntStream.rangeClosed(1, n).forEach(i -> connections.put(i, new HashSet<>()));  
        IntStream.rangeClosed(1, n).forEach(i -> redirects.put(i, i));
        Stream.of(cities).forEach(uv -> connect(connections, redirects, uv[0], uv[1]));
        return connections.
            values().
            stream().
            mapToLong(g -> c_road < c_lib ? g.size() * c_road + c_lib : (g.size() + 1) * c_lib).sum();
    }
    
    static void connect(Map<Integer, Set<Integer>> connections, Map<Integer, Integer> redirects, int u, int v)
    {
        int ucurr = redirects.get(u);
        int vcurr = redirects.get(v);
        
        if(ucurr != vcurr)
        {
            int dest = Math.min(ucurr, vcurr);
            int index = Math.max(ucurr, vcurr);
            
            connections.get(dest).add(index);
            redirects.put(index, dest);
            
            connections.get(dest).addAll(connections.get(index));
            for(int n : connections.get(index))
            {
                redirects.put(n, dest);
            }
            
            connections.remove(index);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int c_lib = in.nextInt();
            int c_road = in.nextInt();
            int[][] cities = new int[m][2];
            for(int cities_i = 0; cities_i < m; cities_i++){
                for(int cities_j = 0; cities_j < 2; cities_j++){
                    cities[cities_i][cities_j] = in.nextInt();
                }
            }
            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
        }
        in.close();
    }
}
