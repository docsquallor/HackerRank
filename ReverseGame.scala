object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var t = sc.nextInt();
        for(i <- 1 to t)
        {
            val n = sc.nextInt();
            val k = sc.nextInt();
            println(if(k >= (n - 1) / 2) (n - 1 - k) * 2 else 1 + 2 * k);
        }
    }
}
