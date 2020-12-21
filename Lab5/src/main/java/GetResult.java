public class GetResult {
    private String url;
    private int count;

   GetResult(String url,int count){
        this.count = count;
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public String getUrl() {
        return url;
    }
}
