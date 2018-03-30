import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] kaprekarNumbers(int p, int q) {
    
      Set<Long> k = new TreeSet<>();
      for(long i = p ; i <= q; i++)
      {
          long sq = i * i;
          long d = (long) Math.ceil(Math.log10(i + 1e-5));
          long pow = (long) Math.pow(10, d);
          long r = sq % pow;
          long l = sq / pow;          
          if(r + l == i)
          {
              k.add(i);
          }
      }
        
        return k.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();
        int[] result = kaprekarNumbers(p, q);
        
        if(result.length == 0)
        {
            System.out.println("INVALID RANGE");
            in.close();
            return;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
