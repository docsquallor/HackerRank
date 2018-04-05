object Solution {
    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        for(i <- 1 to sc.nextInt()){
            var x = sc.nextDouble();
            println((1 to 9).
                    foldLeft((1.0, 1.0)){
                    case ((a, b), c) => (a + b * x / c, b * x / c)
                    }._1)
        }
    }
}
