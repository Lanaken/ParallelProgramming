import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ResultActor extends AbstractActor {
    private ActorRef storage;

    ResultActor(ActorRef storage){
        this.storage = storage;
    }

    private String run(String functionName, String script, Object... args) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(script);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName,args).toString();
    }

    private void runTest(Request test){
        String body;
        try {
            String actualResult = run(test.getFunctionName(), test.getJsScript(),test.getParams());
            body = actualResult.equals(test.getExpectedResult()) ? "Right answer" : "Wrong";
        }
        catch (ScriptException exception) {
            body = "ScriptError :" + exception.getLocalizedMessage();
        }
        catch (NoSuchMethodException exception){
            body = "No such Method :" + exception.getLocalizedMessage();
        }
        storage.tell(new SingleResult(test.getPackageId(),body), ActorRef.noSender());
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(Request.class, this::runTest)
                .build();
    }
}
