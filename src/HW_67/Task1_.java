package HW_67;
/*
@date 18.12.2023
@author Mihail Nedioglo
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
