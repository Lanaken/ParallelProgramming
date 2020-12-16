import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Test implements Serializable {
    private String testName;
    private String expectedResult;
    private Object[] params;
    private String result;

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
}
