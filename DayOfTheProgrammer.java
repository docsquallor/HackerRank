import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int year){
        if(year < 1918)
        {
            int daysFebOverflow = year % 4 == 0 ? 1 : 0;
            int day = 13 - daysFebOverflow;
            return String.format("%d.09.%d", day, year);
        }
        else if(year == 1918)
        {
            return "26.09.1918";
        }
        else
        {
            int daysFebOverflow = year % 400 == 0 ? 
                                                    1 : year % 100 != 0 && year % 4 == 0 ? 
                                                        1 : 0;      
            int day = 13 - daysFebOverflow;
            return String.format("%d.09.%d", day, year);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
