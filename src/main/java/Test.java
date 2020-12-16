import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Test implements Serializable {
    private final String testName;
    private final String expectedResult;
    private final Object[] params;
    private String result;
    private Request master;

    @JsonCreator
    Test(@JsonProperty("testName")String testName, @JsonProperty("expectedResult")String expectedResult, @JsonProperty("params")Object[] params){
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public void setResult(String result){
        this.result = result;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public Object[] getParams() {
        return params;
    }

    public String getResult() {
        return result;
    }

    public String getTestName() {
        return testName;
    }

    public Request getMaster() {
        return master;
    }

    public void setMaster(Request master) {
        this.master = master;
    }
}
