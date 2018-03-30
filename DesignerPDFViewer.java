import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int designerPdfViewer(int[] h, String word) {
        return word.length() * word.chars().map(c -> h[c - 'a']).max().orElse(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i = 0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}
