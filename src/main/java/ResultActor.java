import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ResultActor extends AbstractActor {
    private ActorRef storage;

    ResultActor(ActorRef storage){
        this.storage = storage;
    }

    private String runTest(){
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval()
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
