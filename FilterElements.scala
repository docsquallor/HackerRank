object Solution {

    def main(args: Array[String]) {
        val lines = io.Source.stdin.getLines
        val t = lines.next.toInt
        
        val sizeFilter = (t : (Int, Int, Array[Int])) => 
        {
            val sizeMap = t._3.foldLeft(Map[Int, Int]())((a, b) => a.get(b) match {
                            case Some(e) => a + (b -> (e + 1))
                            case None => a + (b -> 1)
                            }).filter(_._2 >= t._2)
            t._3.distinct.filter(sizeMap.contains)
        }
        Stream.continually((lines.next.split(" ").map(_.toInt), lines.next.split(" ").map(_.toInt))).take(t).
        map(t => (t._1(0), t._1(1), t._2)).map(sizeFilter).
        map(l => if(l.size == 0) "-1" else l.mkString(" ")).foreach(println)
    }
}
