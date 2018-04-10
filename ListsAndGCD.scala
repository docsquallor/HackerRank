object Solution {

    def main(args: Array[String]) {
        def gcd(a : Map[Int, Int], b : Map[Int, Int]) : Map[Int, Int] = {
            a.collect{case(k, v) if(b.contains(k)) => (k, math.min(v, b(k)))}}

        println(io.Source.stdin.getLines.drop(1).map(_.split(" ").map(_.toInt).grouped(2).
                                             foldLeft(Map[Int, Int]())((a, b) => a + (b(0) -> b(1)))).
                reduce(gcd).toSeq.sortBy(_._1).map(kv => s"${kv._1} ${kv._2}").mkString(" "))
    }
}
