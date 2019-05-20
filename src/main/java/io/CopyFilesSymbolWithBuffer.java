package io;

import java.io.*;

public class CopyFilesSymbolWithBuffer {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("c:/data.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter("c:/result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while (bufferedReader.ready()){
            bufferedWriter.write((char) bufferedReader.read());
        }

        bufferedWriter.close();
        fileWriter.close();

        bufferedReader.close();
        fileReader.close();
    }
}
