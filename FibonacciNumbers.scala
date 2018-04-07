object Solution {
    
     def fibonacci(x:Int):Int = {         
      lazy val fibs:Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
      fibs.take(x).last
     }

    def main(args: Array[String]) {
         println(fibonacci(readInt()))

    }
}
