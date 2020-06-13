import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class URLPool {
    private LinkedList<Data> open_list = new LinkedList<>();
    private LinkedList<Data> close_list = new LinkedList<>();

    // Добавляем адрес в открытый список
    public synchronized void addUrlData(Data data){
        open_list.add(data);
    }
    public LinkedList<Data> getOpen_list() {
        return open_list;
    }
    public synchronized Data getLastURLData(){
        Data last = open_list.removeLast();
        close_list.add(last);
        return last;
    }
    public boolean isEmptyOpen(){
        return open_list.isEmpty();
    }
    public void fileOutput(String path){
        try(FileOutputStream streamer=new FileOutputStream(path)){
            String line = "";

            for(Data data : close_list)
                line += data.getUrl() + " " + data.getIteration() + "\n";
            byte[] buffer = line.getBytes();
            streamer.write(buffer, 0, buffer.length);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    // Выводим в консоль
    public void consoleOut(){
        for(Data data : close_list)
            System.out.println(data.getUrl() + " " + data.getIteration());
    }
}