import scala.annotation.tailrec
object Solution {

    def main(args: Array[String]) {
       val seive = (end : Int) => Stream.from(3, 2).takeWhile(_ <= end).diff(Stream.from(3, 2).takeWhile(_ <= math.sqrt(end).toInt).flatMap(i => Stream.from(i * i, 2 * i).takeWhile(_ <= end))).toList
        val primes = 2 +: seive(100000)
        @tailrec
        def factorize(n : Int, acc : scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map[Int, Int](), p : List[Int] = primes) : scala.collection.mutable.Map[Int, Int] = n match{
            case 1 => acc
            case _ if(p.isEmpty) => acc += (n -> 1)
            case _ if(n % p.head == 0) => factorize(n / p.head, acc.get(p.head) match {
                case Some(v) => acc += (p.head -> (v + 1))
                case None => acc += (p.head -> 1)
            }, p)
            case _ => factorize(n, acc, p.tail)
        }
       io.Source.stdin.getLines.drop(1).map(_.split(" ").map(_.toInt)).map(l => (l(0), l(1))).
        map(t => (factorize(t._1), factorize(t._2))).map(t => t._1.filterKeys(t._2.contains).map(kv => (kv._1, math.min(kv._2, t._2(kv._1))))).map(_.values).map(_.foldLeft(1)((a, b) => a * (b + 1))).foreach(println)
    }
}
