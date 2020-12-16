import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class ResultActor extends AbstractActor {
    private ActorRef storage;

    ResultActor()
    @Override
    public Receive createReceive() {
        return null;
    }
}
