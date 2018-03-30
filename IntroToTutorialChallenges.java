import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int introTutorial(int V, int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while(lo < hi && arr[(lo + hi) / 2] != V)
        {
            if(arr[(lo + hi) / 2] < V)
            {
                lo = (lo + hi) / 2 + 1;
            }
            else
            {
                hi = (lo + hi) / 2 - 1;
            }
        }
        
        return V == arr[(lo + hi) / 2] ? (lo + hi) / 2 : -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = introTutorial(V, arr);
        System.out.println(result);
        in.close();
    }
}
