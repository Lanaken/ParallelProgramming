import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends AbstractActor {
    private Map<String, ArrayList<Test>> store = new HashMap<>();
    private void input(Request request){
        String packageId = request.g
    }
    @Override
    public Receive createReceive() {
        return null;
    }
}
