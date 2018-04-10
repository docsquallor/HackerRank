import scala.annotation.tailrec
object Solution {
    
    def numberOfWays(X:Int, N:Double) :Int = {
       val toN = (1 to math.pow(X, 1 / N).toInt).map(math.pow(_, N).toInt).toArray
       @tailrec 
       def ways(index : Int = 0, acc : Map[Int, Int] = Map[Int, Int](0 -> 1)) : Int = {
           if(index >= toN.length) acc.getOrElse(X, 0)
           else 
           {
               val curr = toN(index);
               ways(index + 1, 
                    acc ++ acc.filterKeys(_ + curr <= X).map{case (k, v) => (k + curr, acc.getOrElse(k + curr, 0) + v)})
            }
       }
        
        ways()
    }

    def main(args: Array[String]) {
       println(numberOfWays(readInt(),readInt()))
    }
}
