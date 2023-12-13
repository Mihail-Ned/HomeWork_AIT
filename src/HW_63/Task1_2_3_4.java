package HW_63;
/*
 * @date 12.12.2023
 * @author Mihail Nedioglo
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1_2_3_4 {
    public static void main(String[] args) {
/*
 Task 1:
 Напишите регулярное выражение для поиска всех почтовых индексов, состоящих из пяти цифр.
 Пример строки:
        "Мой индекс 12345, а его индекс 67890. А число 456789 не подходит"
 Ожидаемый результат:
        "12345", "67890"
*/

/*
        // 1 Variant
        String input = "Мой индекс 12345, а его индекс 67890. А число 456789 не подходит";
        String CodePattern = "\\b\\d{5}\\b";
        Pattern pattern4 = Pattern.compile(CodePattern);
        Matcher matcher4 = pattern4.matcher4(input);

        while (matcher4.find()) {
            System.out.println("Task_1: " + matcher4.group());
        }
*/

/*
        // 2 Variant
        String input = "Мой индекс 12345, а его индекс 67890. А число 456789 не подходит";
        Pattern pattern4 = Pattern.compile("\\b\\d{5}\\b");
        Matcher matcher4 = pattern4.matcher4(input);

        while (matcher4.find()) {
            System.out.println("Task_1: " + matcher4.group());
        }
*/

/*
        // 3 Variant
        Pattern pattern4 = Pattern.compile("\\b\\d{5}\\b");
        Matcher matcher4 = pattern4.matcher4("Мой индекс 12345, а его индекс 67890. А число 456789 не подходит");

        while (matcher4.find()) {
            System.out.println("Task_1: " + matcher4.group());
        }
*/
/*

        // 4 Variant
        Pattern pattern = Pattern.compile("\\b\\d{5}\\b");
        Matcher matcher = pattern.matcher("Мой индекс 12345, а его индекс 67890. А число 456789 не подходит");

        while (matcher.find()) System.out.println("Task_1: " + matcher.group());
*/

        // 5 Variant
        Matcher matcher = Pattern.compile("\\b\\d{5}\\b").matcher("Мой индекс 12345, а его индекс 67890. А число 456789 не подходит");
        while (matcher.find()) System.out.println("task_1: " + "start-" + matcher.start() + " : " + matcher.group());
/*
Task 2:
Найти все слова, начинающиеся с "re".

Пример строки: "I need to rewrite and reread these reports."
Ожидаемый результат: "rewrite", "reread", "reports"
*/

        Pattern pattern2 = Pattern.compile("\\bre\\w+\\b");
       // Pattern pattern2 = Pattern.compile("\\bre\\w*\\b");
        Matcher matcher2 = pattern2.matcher("I need to rewrite and reread these re reports.");

        while (matcher2.find()) System.out.println("Task_2: " + "start-" + matcher2.start() + " : " +  matcher2.group());

/*
Task 3:
Найти все номера телефонов в формате "+XXX-XXX-XXXX".

Пример строки:
      "Мои номера: +123-456-7890, +987-654-3210."
Ожидаемый результат:
      "+123-456-7890", "+987-654-3210"
*/

        Pattern pattern3 = Pattern.compile("\\+\\b\\d{3}-\\d{3}-\\d{4}\\b");
        Matcher matcher3 = pattern3.matcher("Мои номера: +123-456-7890, +987-654-3210.");

        while (matcher3.find()) System.out.println("Task_3: " + "start-" + matcher3.start() + " : " + matcher3.group());

/*
Task 4:
Опционально
Найти все email-адреса.

Пример строки:
      "Мои контакты: email@example.com, test.email@domain.ru."
Ожидаемый результат:
      "email@example.com", "test.email@domain.ru"
 */

        Pattern pattern4 = Pattern.compile("\\b([a-zA-Z]\\w{1,2}[\\w%#!&*]?\\.?[\\w%#!&*]+)@[a-zA-Z]{3,}\\.?[a-zA-Z]{3,}\\.[a-zA-Z]{2,3}\\b");
        Matcher matcher4 = pattern4.matcher("Мои контакты: email@example.com, test.email@domain.ru.");

        while (matcher4.find()) {
            System.out.println("Task_4: " + "start-" + matcher4.start() + " : " + matcher4.group());
            System.out.println("userName: " + matcher4.group(1));
        }





    }//main


}
