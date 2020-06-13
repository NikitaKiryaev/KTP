public class CrawlerTask implements Runnable {

    private URLPool pool;
    private int iteration;
    private String threadName;

    public CrawlerTask(URLPool pool, int iteration, String threadName){
        this.pool = pool;
        this.iteration = iteration;
        this.threadName = threadName;
    }
    @Override
    public void run() {
        Data data = getURL();
        while(data != null){
            if(data.getIteration() != iteration){
                Find search = new Find(pool, data);
                search.parsing();
            }
            data = getURL();
        }
        if(data == null)
            System.out.println("Превышен тайм-аут ожидания ссылки в потоке: " + threadName);
    }
    private Data getURL(){
        if(pool.isEmptyOpen())
            for(int i = 0; i < 20; i++){
                // Ожидание
                waiting();
                if(!pool.isEmptyOpen())
                    break;
            }
        if(!pool.isEmptyOpen())
            return pool.getLastURLData();
        else
            return null;
    }
    private void waiting(){
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}