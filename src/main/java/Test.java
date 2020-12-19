import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {
    private final String testName;
    private final String expectedResult;
    private final List<Object> params;
    private String result;
    private Request parent;

    @JsonCreator
    Test(@JsonProperty("testName")String testName, @JsonProperty("expectedResult")String expectedResult, @JsonProperty("params") List<Object> params){
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

    public List<Object> getParams() {
        return params;
    }

    public String getResult() {
        return result;
    }

    public String getTestName() {
        return testName;
    }

    public Request getParent() {
        return parent;
    }

    public void setMaster(Request parent) {
        this.parent = parent;
    }
}
