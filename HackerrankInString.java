import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String hackerrankInString(String s) {
        return s.matches(".*h.*a.*c.*k.*e.*r.*r.*a.*n.*k.*") ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }
}
