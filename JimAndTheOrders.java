import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] jimOrders(int[][] orders) {
        Comparator<int[]> orderComp = new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2)
            {
                return o1[1] + o1[2] - o2[1] - o2[2];
            }
        };
        
        return IntStream.range(0, orders.length).
                mapToObj(i -> new int[]{i + 1, orders[i][0], orders[i][1]}).
                sorted(orderComp).
                mapToInt(o -> o[0]).
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
