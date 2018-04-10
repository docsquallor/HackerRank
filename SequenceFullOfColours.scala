import scala.annotation.tailrec
object Solution {
    
    @tailrec
    def full(c : List[Char], diff : (Int, Int)) : Boolean = {
        val update = (c : Char) => c match {
                                        case 'R' => (diff._1 + 1, diff._2)
                                        case 'G' => (diff._1 - 1, diff._2)
                                        case 'Y' => (diff._1, diff._2 + 1)
                                        case 'B' => (diff._1, diff._2 - 1)
                                    }
        
        if(c.isEmpty) diff._1 == 0 && diff._2 == 0
        else 
        {
            val t = update(c(0))
            if(math.abs(t._1) <= 1 && math.abs(t._2) <= 1) full(c.tail, t) else false
        }
    }
    
    def main(args: Array[String]) {
        val lines = io.Source.stdin.getLines
        val t = lines.next.toInt
        lines.take(t).foreach(s => println(if(full(s.toList, (0, 0))) "True" else "False"))
    }
}
