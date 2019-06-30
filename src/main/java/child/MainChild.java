package child;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainChild {
    public static void main(String[] args) {
        System.out.println();

        System.out.println("Symulator wakacji z dziećmi.");
        System.out.println();

        Child[] children = new Child[5];
        for (int i = 0; i < children.length; i++) {
            children[i] = new Child();
        }

        ExecutorService pulaWatkow = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pulaWatkow.submit(children[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Wprowadź tekst, 'stop' zatrzymuje wątek.");
            Scanner scanner = new Scanner(System.in);
            String string = "";
            String temp = "";
            boolean flagStop = false;
            while (!flagStop) {
                System.out.println("Wprowadź tekst:");
                string = scanner.next();
                if (string.equalsIgnoreCase("stop")) {
                    string = temp;
                    flagStop = true;
                }
            }
//            System.out.println(string);
            children[i].dojechalismy();
        }

        pulaWatkow.shutdownNow();

        System.out.println("Wreszcie.");
    }
}
