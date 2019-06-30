package zadanieSilnia;

import java.util.Scanner;

public class MainZadanieSilnia {
    public static void main(String[] args) {
        System.out.println();

        System.out.println("Program oblicza silnię liczby dla pięciu podanych liczb.");
        System.out.println();
        System.out.println();

        int[] ints = new int[5];
        for (int i = 0; i < ints.length; i++) {
            System.out.println("Podaj liczbę nr " + (i +1));
            ints[i] = getInt(1, 15);
        }

        System.out.println();
        System.out.println("Zaczynam obliczenia.");

        ZadanieSilnia[] zadanieSilnias = new ZadanieSilnia[5];
        for (int i = 0; i < zadanieSilnias.length; i++) {
            zadanieSilnias[i] = new ZadanieSilnia(ints[i]);
        }
//        zadanieSilnias[0] = new ZadanieSilnia(4);
//        zadanieSilnias[1] = new ZadanieSilnia(3);
//        zadanieSilnias[2] = new ZadanieSilnia(5);
//        zadanieSilnias[3] = new ZadanieSilnia(2);
//        zadanieSilnias[4] = new ZadanieSilnia(6);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(zadanieSilnias[i]);
        }


        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("Wątki zakończyły pracę, wyniki:");
        for (int i = 0; i < 5; i++) {
            System.out.println("silnia " + zadanieSilnias[i].getLiczba() + ": " + zadanieSilnias[i].getValueSilnia());
        }

        System.out.println("Kończę pracę.");
    }

    public static int getInt(int min, int max) {
        System.out.println("Podaj liczbę całkowitą z przedziału: " + min + " - " + max + ":");
        Scanner scanner = new Scanner(System.in);
        int temp = 0;
        int liczba = 0;
        boolean flag = false;
        do {
//            System.out.println();
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Podaj liczbę całkowitą!");
            }
            temp = scanner.nextInt();
            if (temp < min) {
                System.out.println("Podałeś za małą liczbę!");
                System.out.println("Podaj liczbę całkowitą z przedziału: " + min + " - " + max + ":");
            } else if (temp > max) {
                System.out.println("Podałeś za dużą liczbę!");
                System.out.println("Podaj liczbę całkowitą z przedziału: " + min + " - " + max + ":");
            } else {
                liczba = temp;
                flag = true;
            }
        } while (!flag);
        return liczba;
    }
}
