import akka.actor.AbstractActor;

import java.util.HashMap;
import java.util.Map;

public class Actor extends AbstractActor {
    private Map<String,Long> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return null;
    }
}
