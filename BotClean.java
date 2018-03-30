import java.io.*;
import java.text.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Solution {

    static class Point
    {
        int x, y;
        
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        
        public int manhattanDistance(Point p)
        {
            return Math.abs(p.x - this.x) + Math.abs(p.y - this.y);
        }
    }
    
    static String nextMove(Point b, Point p)
    {
        if(b.x != p.x)
        {
            if(b.x - p.x > 0)
            {
                b.x -= 1;
                return "UP";
            }
            else
            {
                b.x += 1;
                return "DOWN";
            }
        }
        else if(b.y != p.y)
        {
            if(b.y - p.y > 0)
            {
                b.y -= 1;
                return "LEFT";
            }
            else
            {
                b.y += 1;
                return "RIGHT";
            }
        }
        else
        {
            return null;
        }
    }
    
    static Point pollClosest(Set<Point> dirty, Point bot)
    {
        Point min = null;
        int minDist = Integer.MAX_VALUE;
        for(Point p : dirty)
        {
            int dist = p.manhattanDistance(bot);
            if(minDist > dist)
            {
                minDist = dist;
                min = p;
            }
        }   
        dirty.remove(min);
        return min;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] N = Stream.of(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        String[] grid = new String[5];
        
        for(int i = 0; i < 5; i++)
        {
            grid[i] = br.readLine();
        }
        
        Point b = new Point(N[0], N[1]);
        Set<Point> dirty = new HashSet<>();
        
        for(int i = 0 ; i < grid.length; i++)
        {
            char[] chars = grid[i].toCharArray();
            for(int j = 0; j < chars.length; j++)
            {
                if(chars[j] == 'd')
                {
                    dirty.add(new Point(i, j));
                }
            }
        }
        Point closest;
        if((closest = pollClosest(dirty, b)) != null)
        {
            String nextMove;
            if((nextMove = nextMove(b, closest))!= null)
            {
                System.out.println(nextMove);
            }
            else
            {
                System.out.println("CLEAN");
            }
        }
    }
}
