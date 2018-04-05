object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in);
        val L = sc.nextLong();
        val S1 = sc.nextLong();
        val S2 = sc.nextLong();
        val Q = sc.nextInt();
        val RV = S1 - S2;
        val D = Math.sqrt(2) * L;
        for(i <- 1 to Q)
        {
            val q = sc.nextLong();
            println(Math.abs((D - Math.sqrt(2 * q)) / RV))
        }
    }
}
