package HW_68;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/*
@date 19.12.2023
@author Mihail Nedioglo
*/
/*
Task 1: Парковка
Создать многопоточное приложение для симуляции работы парковки с учетом различного времени пребывания автомобилей и ведения статистики.

Создайте парковку на 5 мест.
Напишите код для 10 потоков, где каждый поток представляет собой автомобиль, который пытается припарковаться.
Организовать контроль доступа к парковочным местам. При отсутствии свободных мест автомобиль должен ожидать.
Каждый автомобиль должен проводить на парковке случайное количество времени от 3 до 10 секунд.
Программа должна учитывать общее время, проведенное всеми автомобилями на парковке.
По завершении работы всех потоков программа должна рассчитать и вывести среднее время пребывания одного автомобиля на парковке.
В консоль должны выводиться сообщения о приезде автомобиля, его парковке, времени пребывания на парковке и уезде.
*/
public class Task1_Parking_ {
    // Количество парковочных мест
    private static final int PARKING_SLOTS = 5;
    // Количество автомобилей
    private static final int NUM_CARS = 10;
    // Минимальное время пребывания на парковке (в миллисекундах)
    private static final int MIN_STAY_TIME = 3000; // 3 секунды
    // Максимальное время пребывания на парковке (в миллисекундах)
    private static final int MAX_STAY_TIME = 10000; // 10 секунд

    // Объект для синхронизации доступа к общим ресурсам
    private static final Object lock = new Object();
    // Количество припаркованных автомобилей
    private static int parkedCars = 0;
    // Общее время пребывания всех автомобилей на парковке
    private static long totalParkingTime = 0;

    public static void main(String[] args) throws InterruptedException {
        // Создание пула потоков для автомобилей
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_CARS);

        // Запуск потоков для каждого автомобиля
        for (int i = 0; i < NUM_CARS; i++) {
            executorService.execute(() -> {
                try {
                    // Приезд на парковку
                    arriveAtParkingLot();
                    // Парковка
                    parkCar();
                    // Уезд
                    leaveParkingLot();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Завершение работы пула потоков после завершения всех потоков
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        // Расчет и вывод среднего времени пребывания автомобиля на парковке
        double averageParkingTime = (double) totalParkingTime / NUM_CARS;
        System.out.println("Среднее время пребывания на парковке: " + averageParkingTime / 1000 + " секунд");
    }

    // Симуляция приезда на парковку
    private static void arriveAtParkingLot() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " приехал на парковку.");
        TimeUnit.MILLISECONDS.sleep(1000); // Имитация времени, потраченного на поиск парковочного места
    }

    // Симуляция парковки автомобиля
    private static void parkCar() throws InterruptedException {
        synchronized (lock) {
            // Пока нет свободных мест, автомобиль ожидает
            while (parkedCars >= PARKING_SLOTS) {
                System.out.println(Thread.currentThread().getName() + " ждет свободного места.");
                lock.wait();
            }

            // Автомобиль паркуется
            parkedCars++;
            System.out.println(Thread.currentThread().getName() + " припарковался. Всего припаркованных: " + parkedCars);
        }

        // Случайное время пребывания на парковке
        long stayTime = ThreadLocalRandom.current().nextLong(MIN_STAY_TIME, MAX_STAY_TIME);
        TimeUnit.MILLISECONDS.sleep(stayTime);

        synchronized (lock) {
            // Автомобиль уезжает
            parkedCars--;
            // Учет общего времени пребывания всех автомобилей на парковке
            totalParkingTime += stayTime;
            System.out.println(Thread.currentThread().getName() + " уехал. Всего припаркованных: " + parkedCars);
            // Уведомление других потоков о возможности парковки
            lock.notifyAll();
        }
    }

    // Симуляция уезда с парковки
    private static void leaveParkingLot() {
        // Имитация времени, потраченного на уезд с парковки
        System.out.println(Thread.currentThread().getName() + " уезжает с парковки.");
    }

}
