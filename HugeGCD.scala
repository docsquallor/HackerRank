import scala.annotation.tailrec
object Solution {
    val MOD = 1000000007
    def main(args: Array[String]) {
        val seive = (end : Int) => Stream.from(3, 2).takeWhile(_ <= end).diff(Stream.from(3, 2).takeWhile(_ <= math.sqrt(end).toInt).flatMap(i => Stream.from(i * i, 2 * i).takeWhile(_ <= end))).toList
        val primes = 2 +: seive(10000)
        @tailrec
        def factorize(n : Int, acc : scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map[Int, Int](), p : List[Int] = primes) : scala.collection.mutable.Map[Int, Int] = n match{
            case 1 => acc
            case _ if(n % p.head == 0) => factorize(n / p.head, acc.get(p.head) match {
                case Some(v) => acc += (p.head -> (v + 1))
                case None => acc += (p.head -> 1)
            }, p)
            case _ => factorize(n, acc, p.tail)
        }
        
        println(Stream.continually((readLine(), readLine())).take(2).map(_._2.split(" ").map(_.toInt)).
        map(_.foldLeft(Map[Int, Int]())((a, b) => a ++ factorize(b).map{case (k, v) => (k, v + a.getOrElse(k, 0))})).
        reduce((a, b) => a.filterKeys(b.contains).map{case(k, v) => (k, math.min(v, b(k)))}).toSeq.
        foldLeft(BigInt(1))((a, b) => ((a * (BigInt(b._1).modPow(b._2, MOD))) % MOD)).intValue())
    }
}
