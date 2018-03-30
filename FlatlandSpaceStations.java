import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int flatlandSpaceStations(int n, int[] c) {
        TreeSet<Integer> stations = IntStream.of(c).boxed().collect(Collectors.toCollection(TreeSet :: new));
        int l = stations.pollFirst();
        
        AtomicInteger e = new AtomicInteger(l);
        int m = stations.stream().mapToInt(s -> s - e.getAndSet(s)).max().orElse(0);
        
        int h = Optional.ofNullable(stations.pollLast()).map(p -> n - 1 - p).orElse(n - 1 - l);
        
        return (int) Math.max(m % 2 == 0 ? m / 2 : (m - 1) / 2, Math.max(l, h));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i = 0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = flatlandSpaceStations(n, c);
        System.out.println(result);
        in.close();
    }
}
