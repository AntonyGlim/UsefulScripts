package files_paths;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AllFilesFromDirectoriesToList {

    //by cycle
    public static List<String> getFileTreeByCycle(String root) throws IOException {
        File folder = new File(root);
        List<String> fileArrayList = new ArrayList<>();
        Queue<File> fileQueue = new PriorityQueue<>();
        for (File file : folder.listFiles()) {
            fileQueue.add(file);
        }
        File fileFromQueue;
        while (!fileQueue.isEmpty()){
            if ((fileFromQueue = fileQueue.remove()).isFile()){
                fileArrayList.add(fileFromQueue.getAbsolutePath());
            } else {
                for (File file : fileFromQueue.listFiles()) {
                    fileQueue.add(file);
                }
            }
        }
        return fileArrayList;
    }

    private static List<String> fileArrayList = new ArrayList<>();

    //by recursion
    public static void getFileTreeByRecursion(String root) throws IOException {
        File folder = new File(root);
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) getFileTreeByRecursion(file.toString());
            else fileArrayList.add(file.getName());
        }
    }
}
