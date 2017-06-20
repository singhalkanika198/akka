import akka.actor._



// passing the argument to the object constructor
class hActor(x:String) extends Actor{
	def receive={
		case "Hello"=> {
			print("How are you ")
			print(x);println("?")
		}
		case _=> println("Not a valid entry point")
	}
}


object mainn extends App{
	val sys=ActorSystem("helloworld2")
	val x = sys.actorOf(Props(new hActor("kanika")), name = "helloactor")	
	x ! "Hello"
	x ! "hey"

}