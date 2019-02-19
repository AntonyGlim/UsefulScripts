package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * https://javarush.ru/quests/lectures/questcore.level09.lecture04
 * Копирование по 1 символу
 * (если файл текстовый)
 */
public class CopyFilesSymbolBySymbol {

    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("c:/data.txt");
        FileWriter writer = new FileWriter("c:/result.txt");

        int symbol;
        while (reader.ready()){ //пока есть непрочитанные байты в потоке ввода
            symbol = reader.read(); //читаем один символ (char будет расширен до int)
            writer.write(symbol); //пишем один символ (int будет обрезан/сужен до char)
        }

        reader.close();
        writer.close();
    }
}
