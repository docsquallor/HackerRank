import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] jimOrders(int[][] orders) {        
        return IntStream.range(0, orders.length).
                boxed().
                sorted((a, b) -> orders[a][0] + orders[a][1] - orders[b][0] - orders[b][1]).
                mapToInt(i -> i + 1).
                toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] orders = new int[n][2];
        for(int orders_i = 0; orders_i < n; orders_i++){
            for(int orders_j = 0; orders_j < 2; orders_j++){
                orders[orders_i][orders_j] = in.nextInt();
            }
        }
        int[] result = jimOrders(orders);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
