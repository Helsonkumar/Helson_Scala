package TypeSystem

//Demo to show how to model Data in Functional Programming.
//We have Algebric Data Types used to model Data in Functional programming
// Algebric Data Type : Sum Type  , Product Type
// We use there data types to model our data in Functional Programming
object AlgebricDataType extends App {

}

//*************************************************************************************************
//Product Type :  Type which contains certain types (HAS-A relationship)
//--------------------------------------------------------------------------------------
// To model a type T has a A 'and' B
//--------------------------------------------------------------------------------------

/*trait T {
  def func1: A
  def func2 : B
}
*/
//or
/*case class T(x:A , y:B)*/


//--------------------------------------------------------------------------------------
//To model a type T has A 'or' B
//--------------------------------------------------------------------------------------
/*trait T {
  def func : X
}

trait X
case class A extends X
case class B extends Y*/
//--------------------------------------------------------------------------------------





//*************************************************************************************************
//Sum Type : Type which contains certain type (IS-A relationship)
//--------------------------------------------------------------------------------------
// To model a type T1 is-a A or B
//--------------------------------------------------------------------------------------
/*trait T
case class A() extends T
case class B() extends T
*/

//--------------------------------------------------------------------------------------
//To model a type T2 is-a  A and B
//--------------------------------------------------------------------------------------
/*trait T2 extends A with B*/

//*************************************************************************************************