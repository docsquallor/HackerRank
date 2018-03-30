import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String organizingContainers(int[][] container) {
        
        Map<Integer, Integer> typeCount = new HashMap<>();
        
        IntStream.range(0, container.length).forEach(i -> typeCount.put(i, 0));
        
        for(int i = 0; i < container.length; i++)
        {
            for(int j = 0; j < container.length; j++)
            {
                typeCount.put(j, typeCount.get(j) + container[i][j]);
            }
        }
        
        int[][] compContainer = new int[container.length][container.length];
        
        for(int i = 0; i < container.length; i++)
        {
            int totalBalls = IntStream.of(container[i]).sum();
            for(int j = 0; j < container.length; j++)
            {
               compContainer[i][j] = totalBalls - container[i][j];
            }
        }
        
        return dfs(container, compContainer, typeCount, 0, new HashSet<Integer>()) ? "Possible" : "Impossible";
    }
    
    static boolean dfs(int[][] container, int[][] compContainer, Map<Integer, Integer> typeCount, int index, Set<Integer> taken)
    {
        if(index >= container.length)
        {
            return true;
        }
        
        for(int key : typeCount.keySet())
        {
            if(!taken.contains(key) && (compContainer[index][key] == typeCount.get(key) - container[index][key]))
            {
                taken.add(key);
                if(dfs(container, compContainer, typeCount, index + 1, taken))
                {
                    return true;
                }
                taken.remove(key);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] container = new int[n][n];
            for(int container_i = 0; container_i < n; container_i++){
                for(int container_j = 0; container_j < n; container_j++){
                    container[container_i][container_j] = in.nextInt();
                }
            }
            String result = organizingContainers(container);
            System.out.println(result);
        }
        in.close();
    }
}
