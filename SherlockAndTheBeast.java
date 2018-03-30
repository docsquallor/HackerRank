import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

    public static String[] largestDecentNumber(int[] digits)
    {
        String[] decentNumbers = new String[digits.length];
        int index = 0;
        
        for(int digit : digits)
        {
            if(digit % 3 == 0)
            {
                decentNumbers[index] = constructMaxDecentNumber(digit, 0);
            }
            else
            {
                int threes = -1;
                for(int i = 5; i <= digit; i+=5)
                {
                    if((digit - i) % 3 == 0)
                    {
                        threes = i;
                        break;
                    }
                }

                if(threes != -1)
                {
                    decentNumbers[index] = constructMaxDecentNumber(digit - threes, threes);
                }
                else
                {
                    decentNumbers[index] = "-1";
                }
            }
            
            index++;
        }
        
        return decentNumbers;
    }
    
    public static String constructMaxDecentNumber(int fives, int threes)
    {
        StringBuffer decentNumber = new StringBuffer();
        IntStream.range(0, fives + threes).forEach(i ->
        {
            if(i < fives)
            {
                decentNumber.append("5");
            }
            else
            {
                decentNumber.append("3");
            }
        });
        
        return decentNumber.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();      
        int[] digits = IntStream.generate(sc::nextInt).limit(testCases).toArray();
        Stream.of(largestDecentNumber(digits)).forEach(i -> System.out.println(i));
        sc.close();
    }
}
