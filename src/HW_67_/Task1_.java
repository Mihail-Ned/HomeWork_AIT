package HW_67_;
/*
@date 18.12.2023
@author Mihail Nedioglo
*/
/*
Разработать многопоточное приложение, где
три различных потока печатают три разные буквы (например, 'A', 'B', 'C') в строгом порядке ABC по 20 раз.

Создайте три потока - Каждый поток отвечает за печать определенной буквы ('A', 'B' или 'C'). -
Все три потока запускаются одновременно.

Синхронизация печати:
- Необходимо синхронизировать потоки таким образом, чтобы они печатали свои буквы в последовательности ABC.
То есть, сначала печатается 'A', затем 'B', затем 'C', и цикл повторяется. - Последовательность ABC должна повториться 20 раз.
 */

public class Task1_ {
    private static final Object lock = new Object();
    private static volatile char currentChar = 'A';

    public static void main(String[] args) throws InterruptedException{
        Thread threadA = new Thread(() -> printLetter('A', 20));
        Thread threadB = new Thread(() -> printLetter('B', 20));
        Thread threadC = new Thread(() -> printLetter('C', 20));

        threadA.start();
        threadB.start();
        threadC.start();

    }

    private static void printLetter(char letter, int times) {
        for (int i = 0; i < times; i++) {
            synchronized (lock) {
                while (currentChar != letter) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(letter);

                switch (currentChar) {
                    case 'A':
                        currentChar = 'B';
                        break;
                    case 'B':
                        currentChar = 'C';
                        break;
                    case 'C':
                        currentChar = 'A';
                        break;
                }

                lock.notifyAll();
            }
        }
    }
}
