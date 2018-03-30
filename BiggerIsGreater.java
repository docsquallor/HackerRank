import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String biggerIsGreater(String w) {
        StringBuilder sb = new StringBuilder(w);

        for(int i = w.length() - 1; i >= 0; i--)
        {
            int maxIndex = -1;
            for(int j = i + 1; j < w.length(); j++)
            {
                if(sb.charAt(j) > sb.charAt(i))
                {
                    maxIndex = j;
                }
            }
            
            if(maxIndex != -1)
            {
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(maxIndex));
                sb.setCharAt(maxIndex, c);          
                char[] chars = sb.substring(i + 1).toCharArray();
                Arrays.sort(chars);
                sb.replace(i + 1, sb.length(), new String(chars));        
                return sb.toString();      
            }
        }
        
        return "no answer";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            String w = in.next();
            String result = biggerIsGreater(w);
            System.out.println(result);
        }
        in.close();
    }
}
