import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "testName",
        "expectedResult",
        "params"
})

public class SingleTest {
    @JsonProperty("testName") private String testName;
    @JsonProperty("expectedResult") private String expectedResult;
    @JsonProperty("params") private List<Object> params = null;
    @JsonIgnore private Map<String, Object> unexpectedProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String,Object> getUnexpectedProperties() {
        return unexpectedProperties;
    }

    @JsonProperty("params")
    public List<Object> getParams(){
        return params;
    }

    @JsonProperty("expectedResult")
    public String getExpectedResult() {
        return expectedResult;
    }

    @JsonProperty("testName")
    public String getTestName() {
        return testName;
    }

    @JsonProperty("expectedResult")
    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    @JsonProperty("params")
    public void setParams(List<Object> params) {
        this.params = params;
    }

    @JsonProperty("testName")
    public void setTestName(String testName) {
        this.testName = testName;
    }

    @JsonAnySetter
    public void setUnexpectedProperties(Map<String, Object> unexpectedProperties) {
        this.unexpectedProperties = unexpectedProperties;
    }
}

