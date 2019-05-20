package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * https://javarush.ru/quests/lectures/questcore.level08.lecture02
 * Копирование по массиву байт
 */
public class CopyFilesByByteArray {
    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream("c:/data.txt"); //Создаем поток-чтения-байт-из-файла
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");// Создаем поток-записи-байт-в-файл

        byte[] buffer = new byte[1000];
        while (inputStream.available() > 0) { //пока есть еще непрочитанные байты
            int count = inputStream.read(buffer); // прочитать очередной блок байт в переменную buffer и реальное количество в count
            outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
