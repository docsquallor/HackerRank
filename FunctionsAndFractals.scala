object Solution {

    def fractal(base : List[Int], size : Int, take : Int, fill : Int) : List[List[Int]] = {
        if(size == 0 || take == 0) List.fill(fill)(List[Int]())
        else fractal(base.flatMap(i => List(i - size, i + size)).toList, size / 2, take - 1, fill - 2 * size) :::
        (size to 1 by -1).map(i => base.flatMap(j => List(j - i, j + i)).toList).toList ::: List.fill(size)(base)
    }
    
    def main(args: Array[String]) {
        fractal(List(50), 16, io.Source.stdin.getLines.next.toInt, 63).
        map(i => (1 to 100).map(j => if(i.contains(j)) "1" else "_").mkString).foreach(println)
    }
}
