import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int fairRations(int[] B) {
        int count = 0;
        for(int i = 0; i < B.length - 1; i++)
        {
            if(B[i] % 2 != 0)
            {
                B[i + 1] += 1;
                count += 2;
            }
        }
        
        return B[B.length - 1] % 2 == 0 ? count : -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] B = new int[N];
        for(int B_i = 0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }
        int result = fairRations(B);
        System.out.println(result == -1 ? "NO" : result);
        in.close();
    }
}
