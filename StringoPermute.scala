object Solution {

    def main(args: Array[String]) {
        io.Source.stdin.getLines.drop(1).map(_.grouped(2).toList.map(_.reverse).mkString).foreach(println)
    }
}
