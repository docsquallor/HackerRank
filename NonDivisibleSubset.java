import java.util.*;
import java.util.stream.*;

public class Solution {

    static int nonDivisibleSubset(int k, int[] arr) {
        int[] count = new int[k];
        
        for(int e : arr)
        {
            count[e % k] += 1;
        }
        
        int total = count[0] < 1 ? count[0] : 1;
        for(int i = 1; i < (k + 1)/2; i++)
        {
            if(i != k - i)
            {
                total += Math.max(count[i], count[k - i]);
            }
        }
        
        return total + (k % 2 == 0 ? 1 : 0);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = nonDivisibleSubset(k, arr);
        System.out.println(result);
        in.close();
    }
}
