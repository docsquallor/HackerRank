object Solution {

    def pascal (row : List[Int], r : Int) : List[Int] =
    {
        row.zipWithIndex.map(t => t._1 * r / (r - t._2)) :+ 1
    }
    def main(args: Array[String]) {
        lazy val triangle : Stream[(List[Int], Int)] = 
         (List(1), 0) #:: triangle.scanLeft((List(1, 1), 1))((a, b) => (pascal(a._1, a._2 + 1), a._2 + 1))
        triangle.take(io.Source.stdin.getLines.next.toInt).map(_._1.mkString(" ")).foreach(println)
    }
}
