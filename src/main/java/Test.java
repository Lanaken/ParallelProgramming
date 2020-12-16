import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Data implements Serializable {
    private String testName;
    private String expectedResult;
    private Object[] params;
    private String result;

    @JsonCreator
    Data(@JsonProperty("testName")String testName,@JsonProperty("expectedResult")String expectedResult, @JsonProperty("params")Object[] params){
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public void setResult(String result){
        this.result = result;
    }

    public v
}
