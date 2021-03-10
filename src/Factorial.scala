import scala.reflect.internal.annotations

//** Demo to show how to defuine loops fucntionally
object Factorial {

  def main(args: Array[String]): Unit = {

    def factor(x: Int): BigInt = {
      //** Loop are defined by using the helper functions
      //** We pass in the state of each iteration as the inp to the helper function
      @annotation.tailrec
      def factor_helper(accum: BigInt, inp: Int): BigInt = {

        //** Define the exit condition for the loop
        if (inp == 0)
          accum
        else
        //*Making the recursive call as tail recursion so the same stack owuld be utilized for every iteration.
          factor_helper(accum * inp, inp - 1)
      }

      factor_helper(1, x)
    }


    //** Make the same recursin using while loop
    //** This includes mutation which is bad design for composition
    def whilelooper(x: Int): BigInt = {

      var accum: BigInt = 1
      var inp = x;
      while (inp > 0) {
        accum = accum * inp
        inp -= 1
      }
      accum
    }

    println(factor(4999))
    println(whilelooper(4))


  }

}