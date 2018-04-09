object Solution {

    def main(args: Array[String]) {
        val strings = io.Source.stdin.getLines.take(2).toList
        val p = strings(0).zip(strings(1)).takeWhile(t => t._1 == t._2).map(_._1)
        val pSize = p.size
        println(s"${p.size} ${p.mkString}")
        println(s"${strings(0).size - pSize} ${strings(0).drop(pSize).mkString}")
        println(s"${strings(1).size - pSize} ${strings(1).drop(pSize).mkString}")
    }
}
