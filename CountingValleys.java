import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int countingValleys(int n, String s) {
      int current = 0;
      int direction = 0;
      int valleys = 0;
      for(char c : s.toCharArray())
      {
          direction = current;
          current += c == 'U' ? 1 : -1;
          direction = current - direction;
          valleys += direction > 0 && current == 0 ? 1 : 0;
      }
      return valleys;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }
}
