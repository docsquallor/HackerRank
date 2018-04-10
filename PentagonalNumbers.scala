import scala.annotation.tailrec
object Solution {
    def main(args: Array[String]) {
        val pent = scala.collection.mutable.Map(1L -> 1L, 2L -> 5L)
        @tailrec
        def P(n : Long, acc : Map[Long, Long] = Map[Long, Long]()) : scala.collection.mutable.Map[Long, Long] = pent.get(n) match {
            case Some(e) => if(acc.isEmpty) pent else acc.toSeq.sortBy(_._1).
            foldLeft((pent, e))((a, b) => (pent += (b._1 -> (a._2 + b._2)), a._2 + b._2))._1
            case None => P(n - 1, acc + (n -> (n * 3 - 2)))
        }
        
        val n = io.Source.stdin.getLines.drop(1).map(_.toLong).map(l => P(l)(l)).foreach(println)
    }
}
