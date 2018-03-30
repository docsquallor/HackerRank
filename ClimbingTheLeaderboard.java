import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        
        int[] ranks = new int[alice.length];
        Arrays.fill(ranks, 1);
        int indexS = scores.length - 1;
        int indexA = 0;
        int aliceRank = (int)IntStream.of(scores).distinct().count() + 1;
        
        while(indexS >= 0 && indexA < alice.length)
        {
            int score = -1;
            while(indexS >= 0 && scores[indexS] <= alice[indexA])
            {
                if(score != scores[indexS])
                {
                    score= scores[indexS];
                    aliceRank--;
                }
                indexS--;
            }
            ranks[indexA] = (aliceRank < 1 ? 1 : aliceRank);
            indexA++;
        }
        
        return ranks;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i = 0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i = 0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
