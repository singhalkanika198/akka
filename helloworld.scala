import akka.actor._

class HelloActor1 extends Actor{
	def receive={
		case "Hello"=>println("How are you?")
		case _=>println("huhhhh")
	}
}

object main extends App{
     
     val sys=ActorSystem("FirstSystem")
     val x=sys.actorOf(Props[HelloActor1] , name="x")
     x ! "Hello"
     x ! "Hey"
}