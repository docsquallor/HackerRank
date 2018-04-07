object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        val points = sc.nextInt()
        var b = Stream.continually((sc.nextInt(), sc.nextInt())).take(points).toList
        b = b :+ b.head
        println(b.tail.foldLeft((b.head, 0.0)){
            case((p, acc), (x2, y2)) => ((x2, y2), acc + math.sqrt(math.pow(x2 - p._1, 2) + math.pow(y2 - p._2, 2)))
        }._2)
                           
    }
}
