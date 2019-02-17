package IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * http://java-help.ru/read-text-file-line-by-line-java/
 * Этот пример читает содержимое текстового файла, по одной строке за раз,
 * используя BufferedReader. Каждая текстовая строка выводится на экран.
 */
public class ReadDataFromFile {
    public static void main(String[] args) {

        try{
            FileInputStream fstream = new FileInputStream("C:/file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);
            }
            br.close();
            fstream.close();
        }catch (IOException e){
            System.out.println("Ошибка чтения файла");
        }

    }
}
