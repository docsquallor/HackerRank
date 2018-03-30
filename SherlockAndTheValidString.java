import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isValid(String s){
        Map<Long, Long> frequencyMap = s.chars().
                                            boxed().
                                            collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                                            values().
                                            stream().
                                            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        if(frequencyMap.size() <= 1)
        {
            return "YES";
        }
        if(frequencyMap.size() == 2)
        {
            Map.Entry[] frequencyEntries = new Map.Entry[2];
            int index = 0;
            for(Map.Entry fme : frequencyMap.entrySet())
            {
                frequencyEntries[index++] = fme;
            }
            long f1 = (Long)frequencyEntries[0].getKey();
            long f1Count = (Long)frequencyEntries[0].getValue();
            long f2 = (Long)frequencyEntries[1].getKey();
            long f2Count = (Long)frequencyEntries[1].getValue();
            
            if(Math.min(f1, f2) == 1 && (f1 == Math.min(f1, f2) ? f1Count : f2Count) == 1)
            {
                return "YES";
            }
            else if(Math.abs(f1 - f2) > 1)
            {
                return "NO";
            }
            else if(Math.min(f1Count, f2Count) > 1)
            {
                return "NO";
            }
            
            return "YES";
        }
        else
        {
            return "NO";
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
