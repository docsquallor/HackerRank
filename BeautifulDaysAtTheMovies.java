import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int beautifulDays(int i, int j, int k) {
        return (int)IntStream.range(i, j + 1).filter(n -> (n - reverse(n)) % k == 0).count();
    }
    
    static int reverse(int n)
    {
        int m = 0;
        
        while(n > 0)
        {
            m = m * 10 + n % 10;
            n /= 10;
        }
        
        return m;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}
