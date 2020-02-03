//1. Define a method which returns a Futures
println("Step 1: Define a method which returns a Futures")
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

def donutStock(donut: String): Future[Int] = Future{
  // assume some long running database operation
  println("checking donut stock")
  10
}

//2. Call method which returns a Future
println("\nStep 2: Call method which returns a Future")
import scala.language.postfixOps
import scala.concurrent.Await
import scala.concurrent.duration._
val vanillaDonutStock = Await.result(donutStock("vanilla donut"), 5 seconds)
println(s"Stock of vanilla donut = $vanillaDonutStock")

// Non blocking future result

////1. Define a method which returns a Future
println("Step 1: Define a method which returns a Future")
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
def donutStock(donut: String): Future[Int] = Future{
  // assume some long running database operation
  println("checking donut stock")
  10
}
// 2. Non blocking future result
// Instead of Await.result()  Future.onComplete()
println("\nStep 2: Non blocking future result")
import scala.util.{Failure, Success}
donutStock("vanilla donut").onComplete{
  case Success(stock) => println(s"Stock for vanilla donut = $stock")
  case Failure(e) => println(s"Failed to find vanilla donut stock, exception = $e")
}
Thread.sleep(3000)

// Chain futures using flatMap

// 1. Define a method which returns a Future
println("Step 1: Define a method which returns a Future")
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
def donutStock(donut: String): Future[Int] = Future{
  // assume some long running database operation
  println("checking donut stock")
  10
}

// Define another method which returns a Future
println("\nStep 2: Define another method which returns a Future")
def buyDonuts(quantity: Int): Future[Boolean] = Future{
  println(s"buying $quantity donuts")
  true
}

// 3. Chaining Futures using flatMap
println("\nStep 3: Chaining Futures using flatMap")
val buyingDonuts: Future[Boolean] = donutStock("plain donut").flatMap(qty => buyingDonuts(qty))
import scala.concurrent.Await
import scala.concurrent.duration._
val isSuccess = Await.result(buyingDonuts, 5 seconds)
println(s"Buying vanilla donut was successful = $isSuccess")

// Chaining futures using for comprehension

// 1. Define a method which returns a Future
println("Step 1: Define a method which returns a Future")
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
def donutStock(donut: String): Future[Int] = Future {
  // assume some long running database operation
  println("checking donut stock")
  10
}

// Define another method which returns a Future
println("\nStep 2: Define another which returns a Future")
def buyDonuts(quantity: Int): Future[Boolean] = Future{
  println(s"buying $quantity donuts")
  true
}

// Chaining Future using for comprehension
println("\nStep 3: Chaining Futures using for comprehension")
for{
  stock <- donutStock("vanilla donut")
  isSuccess <- buyDonuts(stock)
}yield println(s"Buying vanilla was successful = $isSuccess")
Thread.sleep(3000)

// Future option with for comprehension
//1. Define a method which returns a Future Option
println("Step 1: Define a method which returns a Future Option")
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
def donutStock(donut: String): Future[Option[Int]] = Future{
  // assume some long running database operation
  println("checking donut stock")
  if(donut == "vanilla donut") Some(10) else None
}
// 2. Define another method which returns a Future
def buyDonuts(quantity: Int): Future[Boolean] = Future{
  println(s"buying $quantity donuts")
  if (quantity > 0) true else false
}
//3. Chaining Future Option using for comprehensions
println("\nStep 3: Chaining Future Option using for comprehension")
for{
  someStock <- donutStock("vanilla donut")
  isSuccess <- buyDonuts(someStock.getOrElse(0))
}yield println(s"Buying vanilla donut was successful = $isSuccess")
































