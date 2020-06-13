import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class Listing {

    private LinkedList<Data> open_list = new LinkedList<>();
    private LinkedList<Data> close_list = new LinkedList<>();

    public void addUrlData(Data data){
        open_list.add(data);
    }
    // Перемещаем адрес в закрытый список
    public void closingUrl(){
        for(Data data: open_list)
            close_list.add(data);

        open_list = new LinkedList<>();
    }
    // Список открытых адресов
    public LinkedList<Data> getOpen_list() {
        return open_list;
    }
    // Вывод в файл
    public void fileOutput(String path){
        try(FileOutputStream fos=new FileOutputStream(path)){
            String string = "";
            for(Data data : close_list)
                string += data.getUrl() + " " + data.getIteration() + "\n";
            for(Data data : open_list)
                string += data.getUrl() + " " + data.getIteration() + "\n";
            byte[] bf = string.getBytes();
            fos.write(bf, 0, bf.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    // Выводим в консоль
    public void consoleOut(){
        for(Data data : close_list)
            System.out.println(data.getUrl() + " " + data.getIteration());

        for(Data data : open_list)
            System.out.println(data.getUrl() + " " + data.getIteration());

    }
}