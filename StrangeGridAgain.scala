object Solution {

    def main(args: Array[String]) {
       val sc = new java.util.Scanner(System.in);
       val r = sc.nextLong();
       var c = sc.nextLong();
       println((10 * ((r - 1) / 2)) + ((r - 1) % 2) + ((c - 1) << 1));
    }
}
