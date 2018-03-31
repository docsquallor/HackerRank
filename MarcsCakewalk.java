import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long marcsCakewalk(long[] calorie) {
        int n = calorie.length;
        Arrays.sort(calorie);
        return IntStream.range(0, n).mapToLong(i -> calorie[n - 1 - i] << i).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] calorie = new long[n];
        for(int calorie_i = 0; calorie_i < n; calorie_i++){
            calorie[calorie_i] = in.nextLong();
        }
        long result = marcsCakewalk(calorie);
        System.out.println(result);
        in.close();
    }
}
