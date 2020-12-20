import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends AbstractActor {
    private Map<String, ArrayList<String>> store = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(SingleResult.class, this::getSingleResult)
                .match(ResultRequest.class, this::sendPackageResult)
                .build();
    }

    private void getSingleResult(SingleResult singleResult){
        String packageID = singleResult.getPackageId();
        String result = singleResult.getResult();
        if (store.containsKey(packageID))
            store.get(packageID).add(result);
        else {
            ArrayList<String> results = new ArrayList<>();
            results.add(result);
            store.put(packageID,results);
        }
    }

    private void sendPackageResult(ResultRequest resultRequest){
        String packageID = resultRequest.getPackageID();
        sender().tell(new PackageResult(packageID,store.get(packageID)), getSelf());
    }
}
