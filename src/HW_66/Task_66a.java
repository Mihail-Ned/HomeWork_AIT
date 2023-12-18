package HW_66;
/*
@date 18.12.2023
@author Mihail Nedioglo
*/

public class Task_66a {
    private static int counter;


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increaseCounter();
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                decreaseCounter();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("значение переменной counter: " + counter);
    }

    private synchronized static void increaseCounter() {

            counter++;
            System.out.println("counter1: " + counter);


    }

    private synchronized static void decreaseCounter() {

                counter--;
                System.out.println("counter2 : " + counter);

    }
}

