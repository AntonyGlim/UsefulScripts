package zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Добавление файла в архив
 */
public class WriteFileIntoZIP {
    public static void main(String[] args) throws IOException {
        // создаем архив
        FileOutputStream zipFile = new FileOutputStream("D:/1/1/test.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //кладем в него ZipEntry – «архивный объект»
        //это пока просто имя?
        zip.putNextEntry(new ZipEntry("3.jpg"));

        //копируем файл "D:/1/1/3.jpg" в энтри "3.jpg" в архиве
        File file = new File("D:/1/3.jpg");
        Files.copy(file.toPath(), zip);

        //закрываем поток
        zip.close();
    }
}
