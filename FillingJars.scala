object Solution {

    def main(args: Array[String]) {
       val sc = new java.util.Scanner(System.in)
       val N = sc.nextInt();
        var sum = 0L
        for(i <- 1 to sc.nextInt())
        {
            val x = sc.nextLong()
            val y = sc.nextLong()
            val q = sc.nextLong()
            sum += (y - x + 1) * q
        }
        
        println(sum / N)
    }
}
