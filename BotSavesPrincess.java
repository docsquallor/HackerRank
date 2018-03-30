import java.io.*;
import java.text.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Solution {

    static String nextMove(int[] b, int px, int py)
    {
        if(b[0] != px)
        {
            if(b[0] - px > 0)
            {
                b[0] -= 1;
                return "UP";
            }
            else
            {
                b[0] += 1;
                return "DOWN";
            }
        }
        else if(b[1] != py)
        {
            if(b[1] - py > 0)
            {
                b[1] -= 1;
                return "LEFT";
            }
            else
            {
                b[1] += 1;
                return "RIGHT";
            }
        }
        else
        {
            return null;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        
        for(int i = 0; i < N; i++)
        {
            arr[i] = br.readLine();
        }
        
        int[] b = {-1, -1};
        int px = -1, py = -1;        
        int i = 0;
        
        while(b[1] == -1 || py == -1)
        {
            b[0] = b[1] == -1 ? i : b[0];
            px = py == -1 ? i : px;
            b[1] = b[1] == -1 ? arr[i].indexOf('m') : b[1];
            py = py == -1 ? arr[i].indexOf('p') : py;
            i += 1;
        }
        String nextMove = nextMove(b, px, py);
        while(nextMove != null)
        {
            System.out.println(nextMove);
            nextMove = nextMove(b, px, py);
        }
    }
}
