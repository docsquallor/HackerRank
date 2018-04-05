object Solution {

    def gcd(x : Int, y : Int) : Int =
    {
        val min = math.min(x, y)
        if(min == 0) math.max(x, y)
        else
        {
            val mod = math.max(x, y) % min
            mod match
            {
                case 0 => min
                case 1 => 1
                case _ => gcd(min, mod)
            }
        }
    }
    
    def main(args: Array[String]) {
        val br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
        br.readLine()
        Stream.continually(br.readLine()).takeWhile(_ != null).foreach{ l =>
            val s = l.split(" ")
            val x1 = Integer.parseInt(s(0))
            val y1 = Integer.parseInt(s(1))
            val x2 = Integer.parseInt(s(2))
            val y2 = Integer.parseInt(s(3))
            
            val p = math.abs(y2 - y1)
            val q = math.abs(x2 - x1)
            println(gcd(p, q) - 1)
        }
    }
}
