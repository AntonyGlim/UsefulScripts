package map.cuncarenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 *
 * @author a.yatsenko
 * Created at 07.12.2020
 */
public class ConcurrentHashMapAsyncPutRemoveExample {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    static Map<Integer /*id*/, Item> items = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        //put first 100 items
        for (int i = 0; i < 100; i++) {
            items.put(i, new Item(i, (int) (Math.random() * 100)));
            System.out.println(ANSI_BLUE + i + " put : " + items.get(i) + ANSI_RESET);
        }

        //remove old
        items.values().stream()
                .filter(i -> i.getNumber() <= 50)
                .forEach(i -> System.out.println(ANSI_RED + i.getId() + " remove : " + items.remove(i.getId()) + ANSI_RESET));

        System.out.println(items);

        //put elements in another thread
        Thread putThread = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                items.put(i, new Item(i, (int) (Math.random() * 100)));
                System.out.println(ANSI_BLUE + i + " put : " + items.get(i) + ANSI_RESET);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //remove elements in another thread
        Thread removeThread = new Thread(() -> {
            int counter = 0;
            while (counter++ < 10) {
                items.values().stream()
                        .filter(i -> i.getNumber() <= 50)
                        .forEach(i -> {
                            System.out.println(ANSI_RED + i.getId() + " remove : " + items.remove(i.getId()) + ANSI_RESET);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                try {
                    Thread.sleep(5_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //print list size
        Thread sizeInfoThread = new Thread(() -> {
            int counter = 0;
            while (counter++ < 50) {
                System.out.println(ANSI_GREEN + "size = " + items.size() + ANSI_RESET);
                try {
                    Thread.sleep(3_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        putThread.start();
        removeThread.start();
        sizeInfoThread.start();

        putThread.join();
        removeThread.join();
        sizeInfoThread.join();

        System.out.println(items);
    }

}
