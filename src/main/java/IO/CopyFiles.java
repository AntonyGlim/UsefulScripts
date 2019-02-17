package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * https://javarush.ru/quests/lectures/questcore.level08.lecture02
 * Копирование по байтам
 */
public class CopyFiles {
    public static void main(String[] args) throws Exception
    {
        FileInputStream inputStream = new FileInputStream("c:/data.txt"); //Создаем поток-чтения-байт-из-файла
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt"); // Создаем поток-записи-байт-в-файл

        while (inputStream.available() > 0) { //пока есть еще непрочитанные байты
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            outputStream.write(data); // и записать его во второй поток
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
