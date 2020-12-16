import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    private String packageId;
    private String jsScript;
    private String functionName;
    private ArrayList<Test> tests;

    @JsonCreator
    Request(@JsonProperty("packageId")String packageId,@JsonProperty("jsScript")String jsScript,
            @JsonProperty("functionName") String functionName,@JsonProperty("tests")ArrayList<Test> tests){
        
    }
}
