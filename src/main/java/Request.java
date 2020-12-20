import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Request implements Serializable {
    private String packageId;
    private String jsScript;
    private String functionName;
    private String expectedResult;
    private List<Object> params;

    Request(String packageId,String jsScript, String functionName,String expectedResult, List<Object> params){
        this.functionName = functionName;
        this.jsScript = jsScript;
        this.packageId = packageId;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public List<Object> getParams() {
        return params;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getPackageId() {
        return packageId;
    }
}
