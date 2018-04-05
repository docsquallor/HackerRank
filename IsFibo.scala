object Solution {

    def main(args: Array[String]) {
       val sc = new java.util.Scanner(System.in)
        lazy val fibs: Stream[Long] = 0L #:: fibs.scanLeft(1L)(_ + _)
        for(i <- 1 to sc.nextInt())
        {
            val n = sc.nextLong()
            println(if(fibs.takeWhile(_ <= n).exists(_ == n)) "IsFibo" else "IsNotFibo")
        }
    }
}
