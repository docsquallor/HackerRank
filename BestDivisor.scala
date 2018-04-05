object Solution {

    def digitSum(x : Int) : Int = {
        x match
        {
            case  0 => 0
            case _ => x % 10 + digitSum(x / 10)
        }
    }
    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var max : Int = 0;
        var minmax : Int = 0
        for(i <- 1 to n)
        {
            val ds = digitSum(i);
            if(n % i == 0 && max < ds)
            {
                max = ds;
                minmax = i;
            }
        }
        println(minmax);
    }
}
