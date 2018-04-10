import scala.annotation.tailrec
object Solution {
    val MOD = 100000007
    def main(args: Array[String]) {
        val fibs = scala.collection.mutable.Map(0 -> 0, 1 -> 1)
        @tailrec
        def fibonacci(n : Int, lindex : Int = 0) : Int =
        {
            fibs.get(n) match {
                case Some(v) => if(lindex == 0) v else (n + 1 to lindex).
                foldLeft((fibs(n - 1), v, n, fibs))((a, b) => (a._2, (a._1 + a._2) % MOD, b, fibs += (b -> ((a._1 + a._2) % MOD))))._2
                case None => fibonacci(n - 1, if(lindex == 0) n else lindex)
            }
        }
        io.Source.stdin.getLines.drop(1).map(_.toInt).map(fibonacci(_)).foreach(println)
    }
}
