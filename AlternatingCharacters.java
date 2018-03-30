import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int alternatingCharacters(String s){
        AtomicInteger acc = new AtomicInteger(-1);
        return s.chars().map(c -> c != acc.getAndSet(c) ? 0 : 1).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
    }
}
