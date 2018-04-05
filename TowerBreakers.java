import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int towerBreakers(int n, int m) {
        return m == 1 || n % 2 == 0 ? 2 : 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int result = towerBreakers(n, m);
            System.out.println(result);
        }
        in.close();
    }
}
