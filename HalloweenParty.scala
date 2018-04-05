object Solution {

    def main(args: Array[String]) {
       val sc = new java.util.Scanner(System.in)
        for(i <- 1 to sc.nextInt())
        {
            println(Option(sc.nextInt()).
                    map(x => math.floor(x.toDouble / 2).toLong * math.ceil(x.toDouble / 2).toLong).get)
        }
    }
}
