import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int surfaceArea(int[][] A) {
        int cost = 0;
        int L = A.length;
        int W = A[0].length;
        for(int i = 0; i < L; i++)
        {
            for(int j = 0; j < W; j++)
            {
                cost += Math.min(2, A[i][j]*2);
                cost += Math.max(0, A[i][j] - (i - 1 >= 0 ? A[i - 1][j] : 0));
                cost += Math.max(0, A[i][j] - (i + 1 < L ? A[i + 1][j] : 0));
                cost += Math.max(0, A[i][j] - (j - 1 >= 0 ? A[i][j - 1] : 0));
                cost += Math.max(0, A[i][j] - (j + 1 < W ? A[i][j + 1] : 0));
            }
        }
        
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }
}
