import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] maximumPerimeterTriangle(int[] x) {
        int[] l = IntStream.of(x).map(i -> ~i).sorted().map(i -> ~i).toArray();
        int index = IntStream.range(0, l.length - 2).
            filter(i -> l[i] < (l[i + 1] + l[i + 2])).findFirst().orElse(-1);
        return index == -1 ? new int[]{-1, -1, -1} : new int[]{l[index + 2], l[index + 1], l[index]};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] l = new int[n];
        for(int l_i = 0; l_i < n; l_i++){
            l[l_i] = in.nextInt();
        }
        int[] result = maximumPerimeterTriangle(l);
        if(result[0] == -1)
        {
            System.out.println("-1");
            in.close();
            return;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
