package HW_55;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 24.11.2023
 * Menu
 *
 * @author Mihail nedioglo (AIT TR)
 */
/*
Дан список транзакций (Transaction) с полями amount, type (DEBIT/CREDIT), timestamp.
Используя Stream API,
вычислите общую сумму для дебетовых и кредитных транзакций отдельно,
а также найдите транзакцию с максимальной суммой.
 */
public class Task2_ {
    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>(List.of(
                new Transaction(100, TransactionType.DEBIT, 123456),
                new Transaction(200, TransactionType.CREDIT, 123457),
                new Transaction(300, TransactionType.DEBIT, 123458),
                new Transaction(400, TransactionType.CREDIT, 123459)
        ));

// Вычислить общую сумму для дебетовых и кредитных транзакций
        int totalDebitAmount = transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.DEBIT)
                .mapToInt(Transaction::getAmount)
                .sum();

        int totalCreditAmount = transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.CREDIT)
                .mapToInt(Transaction::getAmount)
                .sum();

// Найти транзакцию с максимальной суммой
        Transaction transactionWithMaxAmount = transactions.stream()
                //.max((t1, t2) -> t1.getAmount() - t2.getAmount())
                .max(Comparator.comparingDouble(Transaction::getAmount))
                .orElse(null);

        System.out.println("Общая сумма дебетовых транзакций: " + totalDebitAmount);
        System.out.println("Общая сумма кредитных транзакций: " + totalCreditAmount);
        System.out.println("Транзакция с максимальной суммой: " + transactionWithMaxAmount.getAmount());



    }

}
