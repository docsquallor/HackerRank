import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder[] strings = new StringBuilder[100];
        for(int i = 0; i < 100 ; strings[i] = new StringBuilder(), i++);
        for(int a0 = 0; a0 < n; a0++){
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            strings[x].append(a0 < n/2 ? "- " : split[1]+" ");
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100; i++)
        {
            sb.append(strings[i]);
        }     
        System.out.println(sb);
    }
}
