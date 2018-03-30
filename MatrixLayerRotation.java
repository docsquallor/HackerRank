import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void matrixRotation(int[][] matrix, int r) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] cp = new int[n][m];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                cp[i][j] = matrix[i][j];
            }
        }

        for(int k = 0; k < n / 2 && k < m / 2; k++)
        {
            rotate(matrix, cp, r, k, n - 2 * k, m - 2 * k);
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            
            System.out.println();
        }
    }
    
    static void rotate(int[][] matrix, int[][] cp, int r, int k, int n, int m)
    {
        int R = 2 * n + 2 * m - 4;
        int index;
        int[] rot;


        for(int p = 0; p < n; p++)
        {
            index = index(p, 0, n, m);
            rot = reverseIndex((index + r) % R, n, m);
            matrix[k + rot[0]][k + rot[1]] = cp[k + p][k];

            index = index(p, m - 1, n, m);
            rot = reverseIndex((index + r) % R, n, m);
            matrix[k + rot[0]][k + rot[1]] = cp[k + p][k + m - 1];
        }

        for(int p = 0; p < m; p++)
        {
            index = index(0, p, n, m);
            rot = reverseIndex((index + r) % R, n, m);
            matrix[k + rot[0]][k + rot[1]] = cp[k][k + p];
            
            index = index(n - 1, p, n, m);
            rot = reverseIndex((index + r) % R, n, m);
            matrix[k + rot[0]][k + rot[1]] = cp[k + n - 1][k + p];
        }
    }
    
    static int index(int i, int j, int n, int m)
    {
        if(j == 0) // <0> to <n - 1>
        {
            return i;
        }
        else if(i == n - 1) // n - 1 + 1 = <n> to n - 1 + m - 1 = <n + m - 2>
        {
            return n + j - 1;
        }
        else if(j == m - 1) // n + m - 2 + 1 = <n + m - 1> to n + m - 2 + n - 1 = <2 * n + m - 3>
        {
            return 2 * n + m - i - 3; 
        }
        else // 2 * n + m - 3 + 1 = <2 * n + m - 2> to 2 * n + m - 3 + m - 2 = <2 * n + 2 * m - 5>
        {
            return 2 * n + 2 * m - j - 4;
        }
    }
    
    static int[] reverseIndex(int i, int n, int m)
    {
        if(i >= 0 && i < n)
        {
            return new int[]{i, 0};
        }
        else if(i >= n && i < n + m - 1)
        {
            return new int[]{n - 1, i - n + 1};
        }
        else if(i >= n + m - 1 && i < 2 * n + m - 2)
        {
            return new int[]{2 * n + m - i - 3, m - 1};
        }
        else
        {
            return new int[]{0, 2 * n + 2 * m - i - 4};
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        for(int matrix_i = 0; matrix_i < m; matrix_i++){
            for(int matrix_j = 0; matrix_j < n; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        matrixRotation(matrix, r);
        in.close();
    }
}
