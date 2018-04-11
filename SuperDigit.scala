import scala.annotation.tailrec
object Solution {

    def main(args: Array[String]) {
        @tailrec
        def superDigit(x : String) : Int =
        {
            x.length match {
                case 1 => x.toInt
                case _ => superDigit(x.foldLeft(BigInt(0))((a, b) => a + b.asDigit).toString)
            }
        }
        
        val dig = io.Source.stdin.getLines.next.split(" ")
        val sum = dig.head.foldLeft(BigInt(0))((a, b) => a + b.asDigit);
        println(superDigit((sum * dig(1).toInt).toString))
    }
}
