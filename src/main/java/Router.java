import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.SupervisorStrategy;

public class Router extends AbstractActor {
    private ActorRef storageActor;
    private ActorRef testActor;
    private SupervisorStrategy supervisorStrategy;

    Router(ActorSystem actorSystem){
        storageActor = 
    }


    @Override
    public Receive createReceive() {
        return null;
    }
}
