package HW_64;
/*
@date 12.12.2023
@author Mihail Nedioglo
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Task 1:
Напишите регулярное выражение для извлечения имени пользователя и домена из email-адресов.

Пример строки: "Контакт: email@example.com"
Ожидаемый результат: "Имя пользователя: email, Домен: example.com"
*/
public class Task1 {
    public static void main(String[] args) {
        String input = "Контакт: email@example.com";

        Pattern pattern = Pattern.compile("(\\b\\w+\\b)@(\\w+\\.\\w+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Имя пользователя: " + matcher.group(1) + ", Домен: " + matcher.group(2));
            System.out.println( "Task1: " + matcher.group());
        }
/*
Task 2:
Найти первое слово в кавычках в строке.

Пример строки: "Она сказала: 'быстро', а потом добавила: 'осторожно'."
Ожидаемый результат: "быстро"
*/
        System.out.println("\n============================\n");

        //Task2
        Pattern pattern2 = Pattern.compile("('(.*?)')");
        Matcher matcher2 = pattern2.matcher("Она сказала: 'быстро', а потом добавила: 'осторожно'.");
        while (matcher2.find()) {
            System.out.println("Task2: " + matcher2.group(1));
        }

/*
Task 3:
Написать регулярное выражение для извлечения текста из определенного HTML-тега (например, <p>).

Пример строки:
"<p>Это пример текста.</p> <p>Это другой текст.</p>"
Ожидаемый результат: "Это пример текста.", "Это другой текст."
*/

        System.out.println("\n============================\n");

        //Task3
        Pattern pattern3 = Pattern.compile("<p>(.*?)</p>");
        Matcher matcher3 = pattern3.matcher("<p>Это пример текста.</p> <p>Это другой текст.</p>");
        while (matcher3.find()) {
            System.out.println("Task3: " + matcher3.group(1));
        }

/*
Task 4:
Написать регулярное выражение для замены формата даты с "ДД-ММ-ГГГГ" на "ММ/ДД/ГГГГ".

Пример строки: "Дата: 15-03-2023"
Ожидаемый результат: "Дата: 03/15/2023"
*/

        System.out.println("\n============================\n");

        //Task4
        String text = "Дата: 15-03-2023";
        System.out.println(text);
        Pattern pattern4 = Pattern.compile("(\\d{2})[-/](\\d{2})[-/](\\d{4})");
        Matcher matcher4 =  pattern4.matcher(text);
        while (matcher4.find()) {
//            System.out.println(matcher4.group(1));
//            System.out.println(matcher4.group(2));
//            System.out.println(matcher4.group(3));
//            System.out.println(matcher4.group());
        }
        String newText = matcher4.replaceAll("$2-$1-$3"); // 03/15/2023
        System.out.println(newText);




    }
}
