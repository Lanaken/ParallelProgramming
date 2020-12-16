import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class ResultActor extends AbstractActor {
    private ActorRef storage;

    ResultActor(ActorRef storage){
        this.storage = storage;
    }



    @Override
    public Receive createReceive() {
        return null;
    }
}
