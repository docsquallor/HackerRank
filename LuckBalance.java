import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    
    static int luckBalance(int n, int k, int[][] contests) {
        int[] lucks = Stream.of(contests).filter(c -> c[1] == 1).
            mapToInt(c -> ~c[0]).sorted().map(i -> ~i).toArray();
        return IntStream.of(lucks).limit(k).sum() - IntStream.of(lucks).skip(k).sum() + 
            Stream.of(contests).filter(c -> c[1] == 0).mapToInt(c -> c[0]).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] contests = new int[n][2];
        for(int contests_i = 0; contests_i < n; contests_i++){
            for(int contests_j = 0; contests_j < 2; contests_j++){
                contests[contests_i][contests_j] = in.nextInt();
            }
        }
        int result = luckBalance(n, k, contests);
        System.out.println(result);
        in.close();
    }
}
