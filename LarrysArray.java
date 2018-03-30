import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String larrysArray(int[] A) {
        return cycleSort(A, 0) ? "YES" : "NO";
    }
    
    static boolean cycleSort(int[] A, int index)
    {
        if(A.length - index == 3)
        {
            //(012)
            if(A[index] < A[index + 1] && A[index + 1] < A[index + 2])
            {
                return true;
            }
            //(201)
            else if(A[index + 1] < A[index] && A[index + 1] < A[index + 2] && A[index + 2] < A[index])
            {
                int temp = A[index];
                A[index] = A[index + 1];
                A[index + 1] = A[index + 2];
                A[index + 2] = temp;
                return true;
            }
            //(120) =/= (021)
            else if(A[index] < A[index + 1] && A[index + 2] < A[index + 1] && A[index + 2] < A[index])
            {
                int temp = A[index];
                A[index] = A[index + 2];
                A[index + 2] = A[index + 1];
                A[index + 1] = temp;
                return true;
            }
            
            return false;
        }
        
        int min = index;
        
        for(int i = index + 1; i < A.length; i++)
        {
            if(A[i] < A[min])
            {
                min = i;
            }
        }
        
        if(min != index)
        {
            if((min - index) % 2 == 1)
            {
                insert(A, min, index + 1);
                int temp = A[index];
                A[index] = A[index + 1];
                A[index + 1] = A[index + 2];
                A[index + 2] = temp;
            }
            else
            {
                insert(A, min, index);
            }
        }

        return cycleSort(A, index + 1);
    }
    
    static void insert(int[] A, int source, int dest)
    {
        if(source == dest)
        {
            return;
        }
        
        int temp = A[source];
        for(int i = source; i > dest; i--)
        {
            A[i] = A[i - 1];
        }
        A[dest] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] A = new int[n];
            for(int A_i = 0; A_i < n; A_i++){
                A[A_i] = in.nextInt();
            }
            String result = larrysArray(A);
            System.out.println(result);
        }
        in.close();
    }
}
