import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int lilysHomework(int[] arr) {
        int[] arrCopy = IntStream.of(arr).toArray();
        return Math.min(totalSwaps(arr, true), totalSwaps(arrCopy, false));
    }
    
    static int totalSwaps(int[] arr, boolean ascending)
    {
        TreeMap<Integer, TreeSet<Integer>> prePos = new TreeMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(prePos.get(arr[i]) != null)
            {
                prePos.get(arr[i]).add(i);
            }
            else
            {
                prePos.put(arr[i], new TreeSet<>());
                prePos.get(arr[i]).add(i);
            }
        }
        
        int totalSwaps = 0;
        int index = 0;
        Map.Entry<Integer, TreeSet<Integer>> swap;
        
        NavigableMap<Integer, TreeSet<Integer>> pos = ascending ? prePos : prePos.descendingMap();
        while((swap = pos.pollFirstEntry()) != null)
        {
            for(int i : swap.getValue())
            {
                if(i != index && arr[index] != swap.getKey())
                {
                    Set<Integer> destPos = pos.get(arr[index]);
                    destPos.remove(index);
                    destPos.add(i);
                    
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    
                    totalSwaps += 1;
                }
                
                index += 1;
            }
        }

        return totalSwaps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = lilysHomework(arr);
        System.out.println(result);
        in.close();
    }
}
