object Solution {

    def main(args: Array[String]) {
        val getLines = io.Source.stdin.getLines
        getLines.next.toList.zip(getLines.next.toList).foreach(t => print(s"${t._1}${t._2}"))
    }
}
