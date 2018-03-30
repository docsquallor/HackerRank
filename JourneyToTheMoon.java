import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long journeyToMoon(int n, int[][] astronaut) {
        
        Map<Integer, Set<Integer>> subsetMap = new HashMap<>();
        IntStream.range(0, n).forEach(i -> subsetMap.put(i, new HashSet<>()));
        
        Map<Integer, Integer> subsetId = new HashMap<>();
        IntStream.range(0, n).forEach(i -> subsetId.put(i, i));
        
        Stream.of(astronaut).forEach(a -> disjointSubsets(subsetMap, subsetId, a[0], a[1]));
        
        long numWays = 0;
        long nonCountedPeople = n;
        for(Set<Integer> s : subsetMap.values())
        {
            numWays += (s.size() + 1) * (nonCountedPeople - s.size() - 1);
            nonCountedPeople -= s.size() + 1;
        }
        
        return numWays;
    }
    
    static void disjointSubsets(Map<Integer, Set<Integer>> subsetMap, Map<Integer, Integer> subsetId, int i, int j)
    {
        int subsetI = subsetId.get(i), subsetJ = subsetId.get(j);
        if(subsetI == subsetJ)
        {
            return;
        }
        else
        {
            int to = Math.min(subsetI, subsetJ);
            int from = to == subsetI ? subsetJ : subsetI;

            subsetMap.get(to).add(from);
            subsetId.put(from, to);
            
            subsetMap.get(to).addAll(subsetMap.get(from));
            subsetMap.get(from).stream().forEach(v -> subsetId.put(v, to));
            
            subsetMap.remove(from);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] astronaut = new int[p][2];
        for(int astronaut_i = 0; astronaut_i < p; astronaut_i++){
            for(int astronaut_j = 0; astronaut_j < 2; astronaut_j++){
                astronaut[astronaut_i][astronaut_j] = in.nextInt();
            }
        }
        long result = journeyToMoon(n, astronaut);
        System.out.println(result);
        in.close();
    }
}
