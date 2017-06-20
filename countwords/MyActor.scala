import akka.actor._
import akka.event.Logging


class MyActor extends Actor{
	var line=""
	val sys=ActorSystem("mysystem")
	val y=sys.actorOf(Props[WordsCountActor])

	def receive={
		case Sentence(p:String)=>{
			this.line=p
		}

		case "countWordsInLine"=>
		{
			val wordsList=(line.split(" ").toList)
			y ! (("wordsInSentence" , wordsList.length))
		}

		case "endOfSentences"=>{
			y ! "showResult"
		}
		case _=> print("Problem in receiving sentence")
	}
}