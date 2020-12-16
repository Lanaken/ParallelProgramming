import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    private String packageId;
    private String jsScript;
    private String functionName;
    private ArrayList<Test> tests;
}
