import java.io.*;
import java.text.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String nextLine;
        while((nextLine = br.readLine()) != null)
        {
            int[] arr = Stream.of(nextLine.split(" ")).
                            mapToInt(Integer :: parseInt).
                            toArray();
            System.out.printf("%d %d\n", 2 * arr[2] - arr[0], 2 * arr[3] - arr[1]);
        }
    }
}
