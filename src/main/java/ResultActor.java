import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import javax.script.ScriptEngine;

public class ResultActor extends AbstractActor {
    private ActorRef storage;

    ResultActor(ActorRef storage){
        this.storage = storage;
    }

    private String runTest(){
        ScriptEngine
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
