import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static boolean[] wins = new boolean[101];
    
    static
    {
        wins[0] = false;
        wins[1] = false;
        wins[2] = true;
        wins[3] = true;
        wins[4] = true;
        wins[5] = true;
        for(int i = 6; i < wins.length; i++)
        {
            wins[i] = !(wins[i - 2] && wins[i - 3]  && wins[i - 5]);
        }
        
    }
    static String gameOfStones(int n) {
        return wins[n] ? "First" : "Second";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            String result = gameOfStones(n) ;
            System.out.println(result);
        }
        in.close();
    }
}
