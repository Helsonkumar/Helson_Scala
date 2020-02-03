

// Here we have expressed Fibnocci in the form of tail recursion
// Tail recursion helps avoid Stack Overflow issue - Dont do after return of recursive call control
// Closely observe  : Recursion is the replacement of loops in Scala
// Loops avoid the compositional stayle of coding
// ********************************************************
//   RULE FOR EXPRESSING LOOP IN THE FORM OF ITERATION
// ********************************************************
// Loops execute until a condition is statisfied : So identify that and stop iterating if its is true
// For every loop we have accum result of previous loops and the state for the new loop.
// Do the same for Iteration as well

object Fibnocci extends App{
  
  def fibnocci(n:BigInt):BigInt = {
    @annotation.tailrec
    def fibIn(prev0:BigInt,prev1:BigInt,x:BigInt):BigInt ={
      if (x > n) 
        prev1
      else
        fibIn(prev1,prev0+prev1,x+1)
    }
    
    fibIn(0,1,3)
  }
  
  println(fibnocci(100))
  
}