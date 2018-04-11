import scala.annotation.tailrec
object Solution {

    def maxArea(fence : Array[Int]) : Int = {
        if(fence.isEmpty) 0
        else
        {
            val min = fence.min
            @tailrec
            def splitByMin(l : Array[Int], d : Int, acc : List[Array[Int]] = List[Array[Int]]()) : List[Array[Int]] = {
                if(l.isEmpty) acc.reverse
                else
                {
                    val sub = l.takeWhile(_ != d)
                    splitByMin((l diff sub).dropWhile(_ == d), d, sub +: acc)
                }
            }
            val area = fence.min * fence.length
            splitByMin(fence, min).map(maxArea).foldLeft(area)(math.max)   
        }
    }
    
    
    def main(args: Array[String]) {
        io.Source.stdin.getLines.drop(1).map(_.split(" ").map(_.toInt)).map(maxArea).foreach(println)
    }
}
