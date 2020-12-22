import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class Actor extends AbstractActor {
    private Map<String,Long> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(GetResult.class, msg -> {
            boolean isCounted = storage.containsKey(msg.getUrl());
            String url = msg.getUrl();
            if (!isCounted){
                sender().tell(new ResponseResult(isCounted,url,storage.get(url)),getSelf());
            }
        }).match(StoreResult.class, msg -> {
            storage.put(msg.getUrl(),msg.getTime());
        }).build();
    }
}
