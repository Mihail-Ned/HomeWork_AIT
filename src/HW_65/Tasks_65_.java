package HW_65;
/*
@date 14.12.2023
@author Mihail Nedioglo
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks_65_ {
    public static void main(String[] args) {

/*
Task 1:
Найти все вхождения слова "apple", не следующего за словом "green".

Пример строки: "red apple, green apple, just an apple"
Ожидаемый результат: "apple", "apple"
*/

//        Pattern pattern4 = Pattern.compile("(?<!\\bgreen\\s)apple\\b");
//        Pattern pattern4 = Pattern.compile("(?<!green\\s)apple");
        Pattern pattern1 = Pattern.compile("(?<!green )apple");
        Matcher matcher1 = pattern1.matcher("red apple, green apple, just an apple");

        while (matcher1.find()) {
                System.out.println("Task1 : start-" + matcher1.start() + " " + matcher1.group());
        }
/*
Task 2:
Найти слова, которые начинаются непосредственно после цифры.

Пример строки: "3a, 4b, 5cat, d6, e7, f8"
Ожидаемый результат: "a", "b", "cat"
*/
       // Pattern pattern4 = Pattern.compile("(?<=\\d)\\w+");
        Pattern pattern2 = Pattern.compile("(?<=\\d)[a-zA-Z]+");
        Matcher matcher2 = pattern2.matcher("3a, 4b, 5cat, d6, e7, f8");

        while (matcher2.find()) {
            System.out.println("Task2 : start-" + matcher2.start() + " " + matcher2.group());
        }

/*
Task 3:
Найти все имена пользователей, у которых домен в email-адресе "@example.com".

Пример строки: "contact@example.com, user@test.com, admin@example.com"
Ожидаемый результат: "contact", "admin"
*/

        Pattern pattern3 = Pattern.compile("\\b(\\w+)(?=(@example.com))\\b");
        Matcher matcher3 = pattern3.matcher("contact@example.com, user@test.com, admin@example.com");

        while (matcher3.find()) {
            System.out.println("Task3 : start-" + matcher3.start() + " " + matcher3.group());
        }

/*
Task 4:
Найти все слова, заключённого между двумя словами 'start' и 'end'.

Пример строки: "start middle end, beginning center finish"
Ожидаемый результат: "middle"
*/

        // *? -> обозначает "ленивый" квантификатор, который сопоставляет как можно меньше символов, чтобы закончить захват на первом вхождении следующей части паттерна.
        Pattern pattern4 = Pattern.compile("\\bstart\\s([a-zA-Z]*?)\\send\\b");
//        Pattern pattern4 = Pattern.compile("\\bstart\\s(\\w*?)\\send\\b"); //[a-zA-Z0-9_]
//        Pattern pattern4 = Pattern.compile("\\bstart\\s(.*?)\\send\\b"); // Любой символ
        Matcher matcher4 = pattern4.matcher("start middle end, beginning center finish");

        while (matcher4.find()) {
            System.out.println("Task4 : start-" + matcher4.start() + " " + matcher4.group(1));
        }



    }//main
}
