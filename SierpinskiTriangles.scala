object Solution {
    
    def flip(c : Char) : Char = {
        c match
        {
            case '_' => '1'
            case '1' => '_'
        }
    }
    
    def draw(canvas : List[List[Char]], V : (Int, Int), H : Int) : List[List[Char]] =
    {
        canvas.zipWithIndex.map(t => t._1.zipWithIndex.map(u => 
                            if((t._2 - V._1 >= 0) &&
                               (t._2 - V._1 < H) && 
                               (u._2 >= V._2 - (t._2 - V._1)) && 
                               (u._2 <= V._2 + (t._2- V._1))) flip(u._1) else u._1))
    }
    
  def drawTriangles(canvas : List[List[Char]], triangles : List[(Int, Int, Int)], n: Int) : List[List[Char]] = 
    {
        if(n == 0) canvas 
        else 
            drawTriangles(triangles.foldLeft(canvas)((c, t) => draw(c, (t._1, t._2), t._3)), 
                           triangles.flatMap(t => List((t._1, t._2 - t._3, t._3 / 2), 
                                                        (t._1, t._2 + t._3, t._3 / 2), 
                                                        (t._1 + t._3, t._2, t._3 / 2))), 
                           n - 1)
  }

  def main(args: Array[String]) {
    drawTriangles(
        draw(List.fill(32)(List.fill(63)('_')), (0, 31), 32).reverse, 
        List((0, 31, 16)),
        readInt()).map(_.mkString).reverse.foreach(println)
  }
}
