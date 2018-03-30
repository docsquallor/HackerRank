import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int sherlockAndAnagrams(String s){
        return search(new int[s.length()][s.length()][26], s.toCharArray(), 0);
    }
    
    static int search(int[][][] characterSets, char[] str, int index)
    {
        if(index >= str.length)
        {
            return 0;
        }
        
        int anagrams = search(characterSets, str, index + 1);
        characterSets[index][index][str[index] - 'a'] += 1;
        
        for(int j = index + 1; j < str.length; j++)
        {
            System.arraycopy(characterSets[index + 1][j], 0, characterSets[index][j], 0, 26);
            characterSets[index][j][str[index] - 'a'] += 1;
        }
        
        for(int i = index + 1; i < str.length; i++)
        {
            for(int j = 0; i + j < str.length; j++)
            {
                if(Arrays.equals(characterSets[index][index + j], characterSets[i][i + j]))
                {
                    anagrams += 1;
                }
            }
        }
        
        return anagrams;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
