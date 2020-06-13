import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

// Класс App
public class App {

    public static void main(String[] args) throws Exception, MalformedURLException {
        // Запрос данных 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес сайта: ");
        String url = scanner.nextLine();
        System.out.print("Введите глубину поиска: ");
        int iteration = scanner.nextInt();
        scanner.close();

        Listing list = new Listing();
        list.addUrlData(new Data(url, 0));

        for(int i = 0; i < iteration; i++) {
            // Получение списка
            LinkedList<Data> searchList = list.getOpen_list();
            list.closingUrl();
            Find search = new Find(list, searchList);
            search.run();
        }
        // Вывод в файл
        list.fileOutput("test.txt");
    }
}