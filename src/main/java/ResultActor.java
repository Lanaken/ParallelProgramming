import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ResultActor extends AbstractActor {
    private ActorRef storage;

    ResultActor(ActorRef storage){
        this.storage = storage;
    }

    private String run(Test test) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(test.getParent().getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(test.getParent().getFunctionName(),test.getParams()).toString();
    }

    private Test check(Test test) throws ScriptException, NoSuchMethodException {
        String res = run(test);
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
