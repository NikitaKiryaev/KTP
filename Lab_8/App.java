import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

// Класс App

public class App {
    public static void main(String[] args) throws Exception, MalformedURLException {
        // Запрос входных данных
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес сайта: ");
        String url = scanner.nextLine();
        System.out.print("Введите глубину поиска: ");
        int iteration = scanner.nextInt();
        System.out.print("Введите кол-во потоков: ");
        int threads = scanner.nextInt();
        scanner.close();

        URLPool pool = new URLPool();
        pool.addUrlData(new Data(url, 0));
        // Создание списка потоков
        Thread[] threadsList = new Thread[threads];
        
        for(int i = 0; i < threads; i++){
            CrawlerTask task = new CrawlerTask(pool, iteration, "Thread-" + (i + 1));
            threadsList[i] = new Thread(task);
            threadsList[i].start();
        }
        for(Thread thread: threadsList)
            thread.join();
        pool.fileOutput("test.txt");
    }
}