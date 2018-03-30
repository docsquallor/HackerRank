import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.regex.*;

public class Solution {
    
    static TreeMap<Long, Long> factors = new TreeMap<>();
    static TreeSet<Long> seive = new TreeSet<>();
    static
    {
        seive.add(2L);
        factors.put(0L, 0L);
        
        long mult = 1;
        long p = 1;
        long count = 0;
        while(mult <= 1e18)
        {
            p = nextPrime(p);
            mult *= p;
            count += 1;
            factors.put(mult, count);
        }
    }
    
    static long nextPrime(long n)
    {
        Long higher = seive.higher(n);
        if(higher == null)
        {
            higher = seive.last();
            AtomicLong l = new AtomicLong(higher + 1); 
            while(higher <= n)
            {
                if(!seive.stream().anyMatch(p -> l.longValue() % p == 0))
                {
                    higher = l.longValue();
                    seive.add(higher);
                }
                
                l.incrementAndGet();
            }
        }
        
        return higher;
    }

    static int primeCount(long n) {
        return factors.floorEntry(n).getValue().intValue();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            long n = Long.parseLong(scanner.nextLine().trim());

            int result = primeCount(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
