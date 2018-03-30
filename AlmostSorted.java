import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void almostSorted(int[] arr) {
        
        if(isSorted(arr))
        {
            System.out.println("yes");
        }
        
        int swap = -1;
        for(int i = 0; i < arr.length - 1; i++)
        {
            if(arr[i] > arr[i + 1] && swap == -1)
            {
                if(i - 1 < 0 || arr[i + 1] > arr[i - 1])
                {
                    swap = i;
                }
                else
                {
                    swap = i + 1;
                }
                break;
            }
        }
        
        int swap2;
        for(swap2 = arr.length - 1; arr[swap2] > arr[swap]; swap2--);
        
        int temp = arr[swap2];
        arr[swap2] = arr[swap];
        arr[swap] = temp;
        
        if(!isSorted(arr))
        {
            temp = arr[swap2];
            arr[swap2] = arr[swap];
            arr[swap] = temp;
            
            for(int i = 0; i <= (swap2 - swap)/2; i++)
            {
                temp = arr[swap2 - i];
                arr[swap2 - i] = arr[swap + i];
                arr[swap + i] = temp;
            }

            if(isSorted(arr))
            {
                System.out.println("yes");
                System.out.println("reverse "+(swap + 1)+" "+(swap2 + 1)); 
            }
            else
            {
               System.out.println("no"); 
            }
        }
        else
        {
            System.out.println("yes");
            System.out.println("swap "+(swap + 1)+" "+(swap2 + 1));
        }
    }
    
    static boolean isSorted(int[] arr)
    {
        for(int i = 0; i < arr.length - 1; i++)
        {
            if(arr[i] > arr[i + 1])
            {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        almostSorted(arr);
        in.close();
    }
}
