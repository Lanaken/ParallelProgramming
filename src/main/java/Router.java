import akka.actor.*;
import scala.sys.Prop;

public class Router extends AbstractActor {
    private ActorRef storageActor;
    private ActorRef testActor;
    private SupervisorStrategy supervisorStrategy;

    Router(ActorSystem actorSystem){
        storageActor = actorSystem.actorOf(Props.create(S))
    }


    @Override
    public Receive createReceive() {
        return null;
    }
}
