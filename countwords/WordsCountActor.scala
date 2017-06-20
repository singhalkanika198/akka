import akka.actor._
import akka.event.Logging


class WordsCountActor extends Actor{
	var totalWords=0
	def receive={
		case("wordsInSentence",words:Int)=>{
			totalWords=totalWords+words
		}

		case "showResult"=>{
			print("total words in file are:"+totalWords)
		}

		case _=> print("Problem in receiving wordscount")
	}
}