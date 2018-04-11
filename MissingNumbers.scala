object Solution {

    def main(args: Array[String]) {
        val lines = io.Source.stdin.getLines
        println(Stream.continually((lines.next, lines.next)).take(2).map(_._2.split(" ").map(_.toInt)).
        map(t => t.foldLeft(scala.collection.mutable.Map[Int, Int]())((a, b) => a.get(b) match {
            case Some(e) => a += (b -> (e + 1))
            case None => a += (b -> 1)
        })).reduce((a, b) => b.filter(kv => a.getOrElse(kv._1, 0) < kv._2)).keySet.toSeq.sorted.mkString(" "))
    }
}
