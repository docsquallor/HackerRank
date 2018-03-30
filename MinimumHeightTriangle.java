import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int lowestTriangle(double base, double area){
        return (int) Math.ceil(2 * area / base);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int area = in.nextInt();
        int height = lowestTriangle(base, area);
        System.out.println(height);
    }
}
