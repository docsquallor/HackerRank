import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int minimumNumber(int n, String password) {
        int len = Math.max(0, 6 - password.length());
        int dig = password.matches(".*[0-9].*") ? 0 : 1;
        int low = password.matches(".*[a-z].*") ? 0 : 1;
        int up = password.matches(".*[A-Z].*") ? 0 : 1;
        int special = password.matches(".*\\W.*") ? 0 : 1;
        return Math.max(len, dig + low + up + special);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
