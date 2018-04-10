import scala.annotation.tailrec
object Solution {

    val MOD = 100000007
    def main(args: Array[String]) {
        val fact = scala.collection.mutable.Map(0 -> BigInt(1))
        @tailrec
        def factorial(n : Int, lindex : Int = 0) : BigInt = {
            fact.get(n) match {
                case Some(e) if lindex == 0 => e 
                case Some(e) => (n + 1 to lindex).foldLeft((e, fact))((a, b) => (a._1 * b, fact += (b -> (a._1 * b))))._1
                case None if lindex == 0 => factorial(n - 1, n)
                case None => factorial(n - 1, lindex)
            }}
        
        io.Source.stdin.getLines.drop(1).map(_.split(" ")).map(l => (l(0).toInt, l(1).toInt)).map(t => factorial(t._1) / (factorial(t._2) * factorial(t._1 - t._2))).map(_ % MOD).foreach(println)
    }
}
