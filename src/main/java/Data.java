import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;

public class Data implements Serializable {
    private String testName;
    private String expectedResult;
    private Object[] params;

    @JsonCreator
    Data(String testName,String expectedResult,Object[] params){
        
    }
}
