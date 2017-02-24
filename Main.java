package pkg12;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
//Скачать ХТМЛ файл из интернета, путь к файлу получаем из командной строки, скачиваем в отд. потоке, используем Callback

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            HtmlDownloader htmlDownload = new HtmlDownloader();
            Scanner sc = new Scanner(System.in);
            try {
                htmlDownload.htmlDownloader(sc.nextLine());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public static void main(String[] args) {
        Thread thread = new Thread(runnable);
        thread.start();

    }
}
