import java.io.Serializable;
import java.util.ArrayList;

public class Result implements Serializable {
    private String packageID;
    private ArrayList<String> results;

    public Result(String packageID,ArrayList<String> results){
        this.packageID = packageID;
        this.results = results;
    }

    public String getPackageID() {
        return packageID;
    }

    public ArrayList<String> getResults() {
        return results;
    }
}
