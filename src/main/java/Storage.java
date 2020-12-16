import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends AbstractActor {
    private Map<String, ArrayList<Test>> store = new HashMap<>();

    private void input(Test test){
        String packageId = test.getParent().getPackageId();
        if (store.containsKey(packageId))
            store.get(packageId).add(test);
        else{
            ArrayList<Test> tests = new ArrayList<>();
            tests.add(test);
            store.put(packageId,tests);
        }
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Test.class,)
    }
}
