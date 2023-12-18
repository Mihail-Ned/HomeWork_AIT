/*
@date 14.12.2023
@author Mihail Nedioglo
*/
/*Task 1:
Напишите программу, в которой запускается одновременно два потока.
Один поток 1000 раз увеличивает переменную counter на 1,
а второй поток 1000 раз уменьшает туже переменную на 1.
По завершении работы обоих потоков выведите в консоль значение переменной counter.
Убедитесь, что оно равно 0*/
public class Task_66 {
    private static int counter;
    //final Object lock = new Object();
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(Task_66::increaseCounter);
        Thread thread2 = new Thread(Task_66::decreaseCounter);

        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();

        System.out.println("значение переменной counter: " + counter);
    }




    private static void increaseCounter() {
        synchronized (lock) {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
            System.out.println("counter1: " + counter);
        }
    }

    private static void decreaseCounter() {
        synchronized (lock) {
            for (int i = 0; i < 1000; i++) {
                counter--;
            }
            System.out.println("counter2 : " + counter);
        }
    }
}
