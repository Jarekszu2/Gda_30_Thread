package zadanieSilnia;

/*
Napisz aplikację która wczytuje 5 liczb. Każda wczytana liczba jest przekazywana do konstuktora klasy ZadanieSilnia. (Synonim "Task" czyli klasy implementującej Runnable)

Każde ZadanieSilnia ma konstruktor który przyjmuje do pola:
(private int liczba;)

wartość w konstruktorze.
W metodzie run klasy ZadanieSilnia wykonuj następujące instrukcje.
Obliczaj silnię o podanym w numerze (tym podanym w konstruktorze), z tym że pomiędzy każdym obliczeniem silni każ zadaniu (wątkowi) czekać 500ms.

Zadanie po obliczeniu ma wypisać komunikat (na końcu metody run()) "Zakończyłem oblizcenia".

W metodzie Main stwórz 5 zadań (zgodnie z tym co zostało zapisane na początku zadania. Po stworzeniu zadań przekaż je do Wątków.

Wystartuj jednocześnie wszystkie wątki (w pętli). Po wystartowaniu wątków wątek główny (w metodzie main) powinien poczekać
aż pozostałe wątki zakończą pracę, a następnie wypisać wyniki wszystkich obliczeń. Sugerowana treść wyjścia:

"
Wątki zakończyły pracę, wyniki:
silnia 5: 25
silnia 7: 5040
silnia 12: 479001600
silnia 1: 1
silnia 13: 6227020800

Kończę pracę.
"
 */

public class ZadanieSilnia implements Runnable{

    private int liczba;
    private int valueSilnia;

    public ZadanieSilnia(int liczba) {
        this.liczba = liczba;
    }

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    public int getValueSilnia() {
        return valueSilnia;
    }

    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        valueSilnia = silnia(liczba);

        System.out.println("Zakończyłem obliczenia " + "(" + liczba + ").");
    }

    private int silnia(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * silnia(i - 1);
        }
    }
}
