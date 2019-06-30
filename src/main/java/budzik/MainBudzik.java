package budzik;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainBudzik {
    public static void main(String[] args) {
        System.out.println();

        System.out.println("Aplikacja na sygnał (teraz) po zadanym czasie (5 s) wykonuje operację (drukuje napis: 'Co teraz?').");
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        String text = "";
        do {
            System.out.println();
            System.out.println("Wyraz 'teraz' startuje program - napisz text:");
            text = scanner.next();
            if (text.equalsIgnoreCase("teraz")) {
                flag = true;
            }
        } while (!flag);
//        System.out.println(text);

        ScheduledExecutorService watek = Executors.newSingleThreadScheduledExecutor();
        Budzik budzik = new Budzik();
        watek.scheduleWithFixedDelay(budzik, 5, 5, TimeUnit.SECONDS);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        watek.shutdownNow();
    }
}
