object Solution {

    def main(args: Array[String]) {
        def rot (s : List[Char], n : Int = 0) : List[List[Char]] = {
            n - s.length match {
            case 0 => List[List[Char]]()
            case _ => (s.tail :+ s.head) +: rot(s.tail :+ s.head, n + 1)
            }
        }
        
        io.Source.stdin.getLines.drop(1).map(l => rot(l.toList).map(_.mkString).mkString(" ")).foreach(println)
    }
}
