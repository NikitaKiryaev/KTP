import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.LinkedList;

// Поиск ссылок
public class Find implements Runnable {

    private Listing list;
    LinkedList<Data> searchList;

    public Find(Listing list, LinkedList<Data> searchList){
        this.list = list;
        this.searchList = searchList;
    }

    @Override
    public void run() {
        parsing();
    }

    private void parsing() {
        // Перебор списка открытых ссылок на страницы
        for(int g = 0; g < searchList.size(); g++){
            try {  
                URL connect = new URL(searchList.get(g).getUrl());
                BufferedReader in = new BufferedReader(new InputStreamReader(connect.openStream()));
                String line;
                while ((line = in.readLine()) != null)
                    if(line.indexOf("<a href=") != -1)
                        for(String newUrl: line.split("\""))
                            // Проверка полученной ссылки по протоколу
                            if((newUrl.indexOf("http") != -1) && (newUrl.indexOf("https") == -1)){
                                list.addUrlData(new Data(newUrl, (searchList.get(g).getIteration() + 1)));
                                break;
                            }else if(newUrl.indexOf("https") != -1)
                                System.out.println("Найден протокол https: " + newUrl);

                in.close();
            }catch (UnknownHostException ex){
                System.out.println("Неизвестный хост " + ex.getMessage());
            }catch (IOException ex){
                System.out.println("IOException " + ex.getMessage());
            }
        }

    }
}