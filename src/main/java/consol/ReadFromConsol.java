package consol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromConsol {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String path = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //or

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

    }
}
