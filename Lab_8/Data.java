public class Data {
    private String url;
    private int iteration;

    public Data(String url, int iteration) {
        this.url = url;
        this.iteration = iteration;
    }
    public int getIteration() {
        return iteration;
    }
    public String getUrl() {
        return url;
    }
}