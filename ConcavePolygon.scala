import scala.annotation.tailrec
object Solution {

    val O = (0, 0)
    def dist(p1 : (Int, Int), p2 : (Int, Int)) : Double = {
        math.sqrt(math.pow(p2._1 - p1._1, 2) + math.pow(p2._2 - p1._2, 2))
    }
    
    def orientation(p1 : (Int, Int), p2 : (Int, Int), p3 : (Int, Int)) : Int = {
        (p2._2 - p1._2) * (p3._1 - p2._1) - (p2._1 - p1._1) * (p3._2 - p2._2)
    }
    
    def main(args: Array[String]) {
        var c = io.Source.stdin.getLines.drop(1).map(_.split(" ").map(_.toInt)).map(l => (l(0), l(1))).toList
        val p = c.map(p => (p, dist(p, O))).min(Ordering.by((t : ((Int, Int), Double)) => t._2))._1
        def comp(p1 : (Int, Int), p2 : (Int, Int)) : Boolean = {
            val ortn = orientation(p, p1, p2)
            if(ortn == 0) dist(p, p1) > dist(p, p2) else ortn > 0
        }
        c = c.filter(_ != p).sortWith(comp)
        c = c.head +: c.tail.scanLeft((c.head, Option.empty[Double]))((a, b) => (b, Some(orientation(p, a._1, b)))).filter(t => t._2.getOrElse(0) != 0).map(_._1)
        @tailrec
        def isConvex(p : (Int, Int), q : (Int, Int), r : List[(Int, Int)]) : Boolean = {
            if(r.isEmpty) true
            else if(orientation(p, q, r(0)) > 0) isConvex(q, r(0), r.tail)
            else 
            {
                false
            }
        }
        
        println(if(isConvex(p, c.head, c.tail)) "NO" else "YES")
    }
}
