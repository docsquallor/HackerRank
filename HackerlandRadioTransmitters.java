import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int hackerlandRadioTransmitters(int[] x, int k) {
        TreeSet<Integer> houses = IntStream.of(x).boxed().collect(Collectors.toCollection(TreeSet::new));
        
        int min = 0;
        Integer house = 0;
        
        while((house =  houses.higher(house))!= null)
        {
            house = houses.lower(houses.lower(house + k + 1) + k + 1);
            min += 1;
        }
        
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
}
