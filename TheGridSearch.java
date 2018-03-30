import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String gridSearch(String[] G, String[] P) {
        int plen = P[0].length();
        for(int i = 0; i <= G.length - P.length; i++)
        {
            int index = -1;
            boolean found = false;
            do
            {
                index = G[i].indexOf(P[0], index == -1 ? 0 : index + 1);
                found = index != -1;
                for(int j = 1; found && j < P.length; j++)
                {
                    found = G[i + j].substring(index, index + plen).equals(P[j]);
                }

                if(found)
                {
                    return "YES";
                }
                
            }while(index != -1);
        }
        
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i = 0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i = 0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            String result = gridSearch(G, P);
            System.out.println(result);
        }
        in.close();
    }
}
