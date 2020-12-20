import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "packageID",
        "jsScript",
        "functionName",
        "tests"
})
public class PackageTest {
  @JsonProperty("packageID") private String packageID;
  @JsonProperty("jsScript") private String jsScript;
  @JsonProperty("functionName") private String functionName;
  @JsonProperty("test") private List<SingleTest> tests;
  @JsonIgnore private Map<String,Object> unexpectedProperties = new HashMap<>();

    @JsonAnySetter
    public void setUnexpectedProperties(Map<String, Object> unexpectedProperties) {
        this.unexpectedProperties = unexpectedProperties;
    }

    @JsonProperty("packageID")
    public String getPackageID() {
        return packageID;
    }

    @JsonProperty("jsScript")
    public String getJsScript() {
        return jsScript;
    }

    @JsonProperty("functionName")
    public String getFunctionName() {
        return functionName;
    }

    @JsonProperty("test")
    public List<SingleTest> getTests() {
        return tests;
    }

    @JsonProperty("packageID")
    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    @JsonAnyGetter
    public Map<String, Object> getUnexpectedProperties() {
        return unexpectedProperties;
    }

    @JsonProperty("functionName")
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @JsonProperty("jsScript")
    public void setJsScript(String jsScript) {
        this.jsScript = jsScript;
    }

    @JsonProperty("test")
    public void setTests(List<SingleTest> tests) {
        this.tests = tests;
    }
}
