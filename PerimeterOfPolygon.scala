object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        val points = sc.nextInt()
        var b = Stream.continually((sc.nextInt(), sc.nextInt())).take(points).toList
        val h = b.head
        b = b.tail :+ b.head
        println(b.foldLeft((h._1, h._2, 0.0)){
            case((x1, y1, acc), (x2, y2)) => (x2, y2, acc + math.sqrt(math.pow(x2 - x1, 2) + math.pow(y2 - y1, 2)))
        }._3)
                           
    }
}
