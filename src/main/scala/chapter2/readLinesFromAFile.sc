import scala.io.Source

if(args.length > 0){
  for(line <- Source.fromFile(args(0)).getLines())
    println(line.length + " " + line)
}
else
  Console.err.println("Please enter filename")

val lines = Source.fromFile(args(0)).getLines().toList
def widthOfLength(s:String) = s.length.toString.length

// With the function above it can be calculated the maximum width like this:
var maxWidth = 0
for(line <- lines)
  maxWidth = maxWidth.max(widthOfLength(line))

// Alternatively

val longestLine = lines.reduceLeft(
  (a, b) => if (a.length > b.length) a else b
)

















