public class StoreResult {
    private String url;
    private long time;

    StoreResult(String url,long time){
        this.url = url;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public long getTime() {
        return time;
    }
}
