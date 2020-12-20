import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

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
  @JsonProperty("packageID") private String functionName;
  @JsonProperty("packageID") private List<> tests;

}
