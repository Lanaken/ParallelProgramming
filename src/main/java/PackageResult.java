import java.util.ArrayList;

public class PackageResult {
    private String packageID;
    private ArrayList<String> results;

    PackageResult(String packageID,ArrayList<String> results){
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
