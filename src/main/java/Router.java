import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.SupervisorStrategy;

public class Router extends AbstractActor {
    private ActorRef storageActor;
    private ActorRef testActor;
    private SupervisorStrategy supervisorStrategy;

    Router


    @Override
    public Receive createReceive() {
        return null;
    }
}
