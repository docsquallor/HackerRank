object Solution {

    def dist(p : (Int, Int), p1 : (Int, Int)) : Double = {
        math.sqrt(math.pow(p1._1 - p._1, 2) + math.pow(p1._2 - p._2, 2))
    }
    
    def orientation(p : (Int, Int), p1 : (Int, Int), p2 : (Int, Int)) : Int = {
        (p1._2 - p._2) * (p2._1 - p1._1) - (p1._1 - p._1) * (p2._2 - p1._2)
    }
    
    def hull(l : List[(Int, Int)], r : List[(Int, Int)]) : List[(Int, Int)] = {
        if(l.size < 2)
        Nil
        else if(r.size == 0)
        l
        else if(orientation(l(1), l(0), r(0)) > 0) hull(r(0) +: l, r.drop(1))
        else hull(l.drop(1), r)       
    }
    
    def filter(r : List[(Int, Int)], p : (Int, Int)) : List[(Int, Int)] = {
        lazy val s : Stream[(Option[(Int, Int)], List[(Int, Int)])] = 
                        (Some(p), r) #:: s.scanLeft(s.head)((a, b) => 
                                    if(a._2.size == 0) (None, a._2) 
                                    else (Some(a._2.head), a._2.dropWhile(x => orientation(p, a._2.head, x) == 0)))
        s.takeWhile(t => !t._1.isEmpty).drop(1).map(_._1.get).toList
    }
    
    def main(args: Array[String]) {
        val n = readInt()
        var points = Stream.continually(readLine().split(" ")).take(n).map(l => (l(0).toInt, l(1).toInt)).toList
        val p = points.min(Ordering.by((p : (Int, Int)) => dist((0, 0), p)))
        
        val comp = (p1 : (Int, Int), p2 : (Int, Int)) => {
            val o = orientation(p, p1, p2)
            if(o == 0) dist(p, p1) - dist(p, p2) > 0 else o > 0
        }
        
        points = points.filter(_ != p).sortWith((p1, p2) => comp(p1, p2))
        points = filter(points, p)
        var convexHull = hull(points.take(2).reverse, points.drop(2))
        println((convexHull.tail :+ convexHull.head).
                foldLeft((convexHull.head, 0.0))((t, b) => (b, t._2 + dist(t._1, b)))._2)
    }
}
