object Solution {

    def main(args: Array[String]) {
       val sc = new java.util.Scanner(System.in);
       val two : BigInt = 2; 
        for(i <- 1 to sc.nextInt())
        {
           val n : BigInt = sc.nextLong();
           val mod : BigInt = 100000; 
           println(two.modPow(n, mod) - 1);
        }
    }
}
