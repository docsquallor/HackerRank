import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int activityNotifications(int[] expenditure, int d) {
        
        int[] expenditureFrequency = new int[201];
        IntStream.of(expenditure).limit(d).forEach(e -> expenditureFrequency[e]++);
        int count = 0;
        for(int i = d; i < expenditure.length; i++)
        {
            if(expenditure[i] >= 2 * median(expenditureFrequency, d))
            {
                count++;
            }
            
            expenditureFrequency[expenditure[i - d]]--;
            expenditureFrequency[expenditure[i]]++;
        }
        
        return count;
    }
    
    
    static double median(int[] frequency, int d)
    {
        int rollingFrequency = 0;
        double sum = 0;
        for(int i = 0; i < frequency.length; i++)
        {
            rollingFrequency += frequency[i];
            if(d % 2 != 0 && rollingFrequency > d / 2)
            {
                return i;
            }
            else if(d % 2 == 0)
            {
                if(rollingFrequency >= d / 2 && sum == 0)
                {
                    sum = i;
                }
                
                if(rollingFrequency > d / 2)
                {
                    sum += i;
                    break;
                }
            }
        }
        return sum / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
}
