import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    static String highestValuePalindrome(String s, int n, int k) {
        char[] chars = s.toCharArray();
        
        Map<Integer, Integer> diffMap = new TreeMap<>();
        for(int i = 0; i < n / 2; i++)
        {
            if(chars[i] != chars[(n - 1) - i])
            {
                diffMap.put(i, (n - 1) - i);
            }
        }
        
        int diff = diffMap.size();
        if(diff > k)
        {
            return "-1";
        }
        
        int excess = k - diff;

        for(Map.Entry<Integer, Integer> diffs : diffMap.entrySet())
        {
            chars[diffs.getKey()] = chars[diffs.getValue()] = (char)Math.max(chars[diffs.getKey()], 
                                                                                 chars[diffs.getValue()]);
        }

        int index = 0;
        while(excess > 0 && index < (n + 1) / 2)
        {
            if(chars[index] != '9' && diffMap.containsKey(index))
            {
                chars[index] = chars[n - 1 - index] = '9';
                excess -= 1;
            }
            else if(excess >= 2 && chars[index] != '9')
            {
                chars[index] = chars[n - 1 - index] = '9';
                excess -= 2;
            }
            else if(n % 2 == 1 && index == n / 2)
            {
                chars[index] = '9';
                excess -= 1;
            }

            index += 1;
        }
        
        return new String(chars);
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scan.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        String s = scan.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
