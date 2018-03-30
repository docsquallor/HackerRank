import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int pickingNumbers(int[] a) {
        Arrays.sort(a);
        int trail = a[0];
        int maxTrailSize = 0;
        int trailSize = 0;
        for(int e : a)
        {
            if(Math.abs(trail - e) <= 1)
            {
                trailSize++;
            }
            else
            {
                if(maxTrailSize < trailSize)
                {
                    maxTrailSize = trailSize;
                }
                
                trail = e;
                trailSize = 1;
            }
        }
        
        return Math.max(maxTrailSize, trailSize);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
