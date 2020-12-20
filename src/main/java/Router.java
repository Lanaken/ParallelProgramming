import akka.actor.*;
import akka.routing.RoundRobinPool;

public class Router extends AbstractActor {
    private ActorRef storageActor;
    private ActorRef testActor;
    private SupervisorStrategy supervisorStrategy;

    Router(){
        this.storageActor = getContext().actorOf(Props.create(Storage.class, Storage::new), "Storage");
        this.testActor = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ResultActor.class, storageActor)), "router");
    }


    @Override
    public Receive createReceive() {
        return null;
    }

    private void receiveResultRequest(ResultRequest resultRequest){
        this.storageActor.tell(resultRequest,getSender());
    }

    private void receive
}
