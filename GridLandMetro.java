import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Line implements Comparable<Line>
    {
        final int c1, c2;
        public Line (int c1, int c2)
        {
            this.c1 = Math.min(c1, c2);
            this.c2 = Math.max(c1, c2);
        }
        
        public int compareTo(Line l)
        {
            return this.c1 != l.c1 ? this.c1 - l.c1 : this.c2 - l.c2;
        }
        
        
        public String toString()
        {
            return "("+c1+", "+c2+")";
        }
    }
    
    static long gridlandMetro(long n, long m, int k, int[][] track) {
        TreeMap<Integer, TreeSet<Line>> gridMap = new TreeMap<>();
        
        for(int i = 0; i < k; i++)
        {
            TreeSet<Line> lines = gridMap.get(track[i][0]);
            if(lines == null)
            {
                lines = new TreeSet<Line>();
                gridMap.put(track[i][0], lines);
            }
            
            lines.add(new Line(track[i][1], track[i][2]));
        }
        
        long cover = 0;
        TreeSet<Line> grid;
        while((grid = Optional.ofNullable(gridMap.pollFirstEntry()).map(Map.Entry :: getValue).orElse(null)) != null)
        {
            int maxCol = 0;
            Line a;
            while((a = grid.pollFirst()) != null)
            {
                if(a.c1 <= maxCol)
                {
                    cover += Math.max(0, a.c2 - maxCol);
                }
                else
                {
                    cover += a.c2 - a.c1 + 1;
                }
                
                maxCol = Math.max(maxCol, a.c2);
            }
        }
        
        return m * n - cover;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] track = new int[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        long result = gridlandMetro(n, m, k, track);
        System.out.println(result);
        in.close();
    }
}
