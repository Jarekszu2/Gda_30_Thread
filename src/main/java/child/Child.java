package child;

/*
"Symulator wakacji z dziećmi"

Napisz aplikację w której wystartowane będzie niemalże jednocześnie 5 zadań.
Zadanie (klasa "Child") jest klasą implementującą interfejs Runnable.

Klasa nie ma konstruktora (ma domyślny) i ma jedno pole. Pole:
- private boolean czyDojechalismy;

Wartość tego pola domyślnie ma wartość "false".

Stwórz metodę:

- public void dojechaliśmy();

Która wewnątrz (w swojej implementacji) ustawia wartość pola na true.

W metodzie run() wewnątrz klasy dokonuje się losowanie "szansy".
Z 20% prawdopodobieństwem losuje się jeden ze string'ów:

"Czy to już?"
"Daleko jeszcze?"
"Dojechaliśmy?"
"Mamo kiedy już będziemy?!"
"Jest mi niedobrze!"

Po wylosowaniu string'a tekst wypisuje się na ekran.
Tekst wypisuje się z częstotliwością 1 raz na sekundę przez każdy z wątków. (opóźnienie wynosi 1000ms)
Wątek pracuje w pętli dopóki wartość pola "czyDojechaliśmy" nie zostanie ustawiona na "true".

W klasie Main, w metodzie main stwórz na początku 5 zadań i pulę wątków z 5 wątkami (fixed lub cached thread pool).

Jednocześnie (w pętli) przekaż wszystkie zadania do puli. Po wystartowaniu metoda main powinna
czekać na wejście ze scannera. Po wpisaniu przez użytkownika "stop" powinien się zatrzymywać JEDEN z "Child'ów".

Oznacza to, że użytkownik musi wpisać 5 razy stop żeby zatrzymać wszystkie wątki. Po zatrzymaniu wszystkich wątków
możesz zatrzymać pulę (shudown) lub poczekać aż się zamknie.

(spróbuj na koniec aplikacji zapisać komunikat "wreszcie")
 */

import java.util.Random;

public class Child implements Runnable{
    private boolean czyDojechalismy = false;

    public void run() {
        String text = "";
        int random = new Random().nextInt(100);
        System.out.println("random: " + random);
        if (random >= 0 && random < 20) {
            text = "Czy to już?";
        } else if (random >= 20 && random < 40) {
            text = "Daleko jeszcze?";
        } else if (random >= 40 && random < 60) {
            text = "Dojechaliśmy?";
        } else if (random >= 60 && random < 80) {
            text = "Mamo kiedy już będziemy?!";
        } else if (random >= 80 && random < 100) {
            text = "Jest mi niedobrze!";
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!czyDojechalismy) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(text);
        }

    }

    public void dojechalismy() {
        czyDojechalismy = true;
    }
}
