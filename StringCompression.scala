import scala.annotation.tailrec
object Solution {    
    def main(args: Array[String]) {
        @tailrec
        def compressor(text : List[Char], acc : StringBuilder = new StringBuilder()) : String = {
            if(text.isEmpty) acc.toString
            else 
            {
                val span = text.span(_ == text.head)
                compressor(span._2, acc.append(if(span._1.size == 1) text.head 
                                            else s"${text.head}${span._1.size}"))
            }
        }
        
        println(compressor(io.Source.stdin.getLines.next.toList))
    }
}
