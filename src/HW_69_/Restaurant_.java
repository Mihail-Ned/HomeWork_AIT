package HW_69_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Restaurant_ {
    // Количество столов в ресторане
    private static final int NUM_TABLES = 5;
    // Максимальное количество заказов, обрабатываемых одновременно
    private static final int MAX_ORDERS_IN_PROCESS = 3;
    // Общее количество посетителей для обслуживания
    private static final int TOTAL_CUSTOMERS = 30;

    // Атомарный счетчик обслуженных посетителей
    private final AtomicInteger servedCustomers = new AtomicInteger(0);
    // Атомарный счетчик общего времени обслуживания
    private final AtomicInteger totalServiceTime = new AtomicInteger(0);

    // Объект для синхронизации доступа к столам
    private final Object tablesLock = new Object();
    // Объект для синхронизации доступа к заказам в обработке
    private final Object ordersInProcessLock = new Object();

    // Симуляция работы ресторана
    public void simulateRestaurant() {
        // Пул потоков для обслуживания посетителей
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_TABLES);

        // Запускаем заданное количество потоков-посетителей
        for (int i = 0; i < TOTAL_CUSTOMERS; i++) {
            executorService.submit(() -> {
                try {
                    occupyTable();
                    processOrder();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    leaveTable();
                }
            });
        }

        // Завершаем работу пула потоков после обслуживания всех посетителей
        executorService.shutdown();
    }

    // Посетитель занимает стол
    private void occupyTable() throws InterruptedException {
        synchronized (tablesLock) {
            // Пока нет свободных столов, поток ожидает
            while (occupiedTables >= NUM_TABLES) {
                tablesLock.wait();
            }
            // Увеличиваем счетчик занятых столов
            occupiedTables++;
        }
    }

    // Посетитель освобождает стол
    private void leaveTable() {
        synchronized (tablesLock) {
            // Уменьшаем счетчик занятых столов
            occupiedTables--;
            // Оповещаем ожидающих потоков
            tablesLock.notifyAll();
        }
    }

    // Обработка заказа
    private void processOrder() throws InterruptedException {
        synchronized (ordersInProcessLock) {
            // Пока достигнуто максимальное количество заказов в обработке, поток ожидает
            while (ordersInProcess >= MAX_ORDERS_IN_PROCESS) {
                ordersInProcessLock.wait();
            }
            // Увеличиваем счетчик заказов в обработке
            ordersInProcess++;
        }

        // Имитация времени обработки заказа (приготовления блюда)
        int processingTime = (int) (Math.random() * 500) + 500;
        Thread.sleep(processingTime);
        // Увеличиваем общее время обслуживания
        totalServiceTime.addAndGet(processingTime);

        synchronized (ordersInProcessLock) {
            // Уменьшаем счетчик заказов в обработке и обслуженных посетителей
            ordersInProcess--;
            servedCustomers.incrementAndGet();
            // Оповещаем ожидающих потоков
            ordersInProcessLock.notifyAll();
        }
    }

    public static void main(String[] args) {
        // Создаем экземпляр ресторана
        Restaurant_ restaurant = new Restaurant_();
        // Запускаем симуляцию работы ресторана
        restaurant.simulateRestaurant();

        // Ожидаем, пока все посетители будут обслужены
        while (restaurant.servedCustomers.get() < TOTAL_CUSTOMERS) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Рассчитываем и выводим статистику
        double averageServiceTime = (double) restaurant.totalServiceTime.get() / TOTAL_CUSTOMERS;
        System.out.println("Общее количество  обслуженных посетителей: " + TOTAL_CUSTOMERS);
        System.out.println("Среднее время обслуживания: " + averageServiceTime + " мили секунд");
    }

    // Количество занятых столов
    private int occupiedTables = 0;
    // Количество заказов в обработке
    private int ordersInProcess = 0;
}