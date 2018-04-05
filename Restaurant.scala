object Solution {

    def gcd(a : Int, b : Int) : Int = {
        Math.max(a, b) % Math.min(a, b) match
        {
            case 0 => Math.min(a, b)
            case _ => gcd(Math.min(a,b), Math.max(a, b) % Math.min(a, b))
        }
    }
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in);
        val q = sc.nextInt()
        val sq = (x : Int) => x * x
        for(i <- 1 to q)
        {
            val l = sc.nextInt()
            val b = sc.nextInt()
            println(l * b / sq(gcd(l, b)));
        }
    }
}
