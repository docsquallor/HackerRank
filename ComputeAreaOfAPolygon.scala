object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        val n = sc.nextInt()
        var points = Stream.continually((sc.nextInt(), sc.nextInt())).take(n).toList
        points = points :+ points.head
        println(points.tail.foldLeft((points.head, 0.0)){
            case(((x1, y1), acc), (x2, y2)) => ((x2, y2), acc + x1 * y2 - x2 * y1)}._2 / 2)
    }
}
