]public class SingleResult {
    private String packageId;
    private String result;

    public SingleResult(String packageId, String result){
        this.packageId = packageId;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getPackageId() {
        return packageId;
    }
}
