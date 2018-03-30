import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int viralAdvertising(int n) {
        int aud = 5;
        int i = 1;
        int like = 0;
        int total = 0;
        while(i <= n)
        {
            like = aud / 2;
            aud = like * 3;
            total += like;
            i++;
        }
        
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = viralAdvertising(n);
        System.out.println(result);
        in.close();
    }
}
