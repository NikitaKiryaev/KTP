import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.LinkedList;

// Поиск ссылок на сайте
public class Find {

    private URLPool list;
    private Data data;
    public Find(URLPool list, Data data){
        this.list = list;
        this.data = data;
    }
    public void parsing() {
        try {
            URL connect = new URL(data.getUrl());
            BufferedReader in = new BufferedReader(new InputStreamReader(connect.openStream()));
            String string;
            while ((string = in.readLine()) != null)
                if(string.indexOf("<a href=") != -1)
                    for(String newUrl: string.split("\""))
                        // Проверка протокола полученной ссылки
                        if((newUrl.indexOf("http") != -1) && (newUrl.indexOf("https") == -1)){
                            list.addUrlData(new Data(newUrl, (data.getIteration() + 1)));
                            break;
                        }else if(newUrl.indexOf("https") != -1)
                            System.out.println("Найден протокол https: " + newUrl);
            in.close();
        }catch (UnknownHostException e){
            System.out.println("Неизвестный хост " + e.getMessage());
        }catch (IOException e){
            System.out.println("IOException " + e.getMessage());
        }
    }
}