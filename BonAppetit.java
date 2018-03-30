import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.atomic.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int K = sc.nextInt();
         AtomicInteger skip = new AtomicInteger(0);
         int total = IntStream.generate(sc::nextInt).limit(N).filter(i -> skip.getAndIncrement() != K).sum() / 2;
         int charged = sc.nextInt();
         System.out.println(charged == total ? "Bon Appetit" : String.format("%d", charged - total));
    }
}
