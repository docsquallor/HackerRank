import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int findDigits(int n) {
        return IntStream.rangeClosed(0, (int)Math.log10(n)).
                boxed().
                map(i -> (n / (int)Math.pow(10, i)) % 10).
                filter(i -> i != 0 && n % i == 0).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                values().stream().reduce((a, b) -> a + b).orElse(0L).intValue();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = findDigits(n);
            System.out.println(result);
        }
        in.close();
    }
}
