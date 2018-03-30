import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] breakingRecords(int[] score) {
        int min = score[0];
        int max = score[0];
        int highBreak= 0, lowBreak = 0;
        for(int s : score)
        {
            if(s > max)
            {
                max = s;
                highBreak += 1;
            }
            else if(s < min)
            {
                min = s;
                lowBreak += 1;
            }
        }
        
        return new int[]{highBreak, lowBreak};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
