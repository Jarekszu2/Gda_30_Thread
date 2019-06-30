package budzik;

/*
Budzik:

Napisz aplikację która na wpisanie komendy:

"teraz"

Rozpoczyna odliczanie timera 25 sekundowego. Po 25 sekundach wypisuje na ekran:
"co teraz?"
 */

public class Budzik implements Runnable{
    public void run() {
        System.out.println("Co teraz?");
    }
}
