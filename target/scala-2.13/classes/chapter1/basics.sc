// A language that grows on you
var capital = Map("US"-> "Washington", "France" -> "Paris")
capital += ("Japan"->"Tokyo")
println(capital("France"))

// Another example of Scala cool features
def factorial(x: BigInt): BigInt =
  if (x == 0) 1 else  x * factorial(x -1)

//The Java way
import java.math.BigInteger

import scala.collection.immutable.HashMap
import scala.collection.mutable

def factorial(x:BigInteger):BigInteger =
  if(x == BigInteger.ZERO)
    BigInteger.ONE
  else
    x.multiply(factorial(x.subtract(BigInteger.ONE)))

//Actor example in Scala
import akka.actor.Actor

class ChecksumActor extends Actor{
  var sum = 0
  def receive = {
    case Data(byte) => += byte
    case GetChecksum(requester) =>
      val checksum = ~(sum & 0xFF) + 1
      requester ! checksum
  }
}

// Scala Functional functionality
val xs = 1 to 3
val it = xs.iterator
eventually {it.next() shouldBe 3}

// Java vs. Scala Comparision

//Java
import java._
class MyClass{
  private int index;
  private String name;

  public MyClass(int index, String name){
    this.index = index;
    this.name = name;
  }
}

//Scala
class MyClass(index:Int, name:String)


// Find whether String variable contains a Upper case letter

// in Java 7 or prior
var name:String = "Nick"
boolean nameHasUpperCase = false;
for(int i = 0; i < name.length(); ++i){
  if (Character.isUpperCase(name.charAt(i))){
    nameHasUpperCase = true;
    break;
  }
}

// in Scala
val nameHasUpperCase = name.exists(_.isUpper)

// Java 8 improvement
boolean nameHasUpperCase =
  name.chars().anyMatch(
      (int ch) -> Character.isUpperCase((char) ch)
  )

// Java vs Scala type inference

//Java
val x: HashMap[Int, String] = new HashMap[Int, String]()

// Scala
val x = new HashMap[Int, String]()
val x: Map[Int, String] = new HashMap()



