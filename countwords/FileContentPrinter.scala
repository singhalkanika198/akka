import akka.actor._
import scala.io.Source
import akka.event.Logging

case class Sentence(sentence:String)

object FileContentPrinter{
	def main(args:Array[String])={
		val sys=ActorSystem("MySystem")
		val x=sys.actorOf(Props[MyActor])
		try{
			val filename="/home/practo/Downloads/akka-quickstart-scala/words"
			for(line <- Source.fromFile(filename).getLines()){
				x !  Sentence(line)
				x ! "countWordsInLine"
			}
		}
		catch{
			case ex: Exception=> ex.printStackTrace()
		} finally{
			x ! "endOfSentences"
		}
	}
}