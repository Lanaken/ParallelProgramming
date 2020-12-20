import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import com.sun.org.apache.xml.internal.security.utils.SignatureElementProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends AbstractActor {
    private Map<String, ArrayList<String>> store = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(SingleResult.class, this::g)
    }
}
