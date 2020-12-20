import akka.actor.*;
import akka.routing.RoundRobinPool;

public class Router extends AbstractActor {
    private ActorRef storageActor;
    private ActorRef testActor;

    Router(){
        this.storageActor = getContext().actorOf(Props.create(Storage.class, Storage::new), "Storage");
        this.testActor = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ResultActor.class, storageActor)), "router");
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ResultRequest.class, this::receiveResultRequest)
                .match(PackageTest.class, this::receivePackageTest)
                .build();
    }

    private void receiveResultRequest(ResultRequest resultRequest){
        this.storageActor.tell(resultRequest,getSender());
    }

    private void receivePackageTest(PackageTest tests){
        tests.getTests().stream()
                .map(test -> new Request(tests.getPackageID(), tests.getFunctionName(),tests.getJsScript(),test.getExpectedResult(),test.getParams()))
                .forEach(msg -> this.testActor.tell(msg,this.storageActor));
    }
}
