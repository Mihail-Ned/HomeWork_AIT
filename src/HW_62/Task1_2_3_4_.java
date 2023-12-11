package HW_62;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Task 1: Поиск Отдельных Цифр
        Напишите регулярное выражение, которое находит все отдельные цифры меньше 7 в строке.

        Пример строки: "Моя дата рождения 2.6.1990"
        Ожидаемый результат: "2", "6", "1", "0"
        */
public class Task1_2_3_4_ {
    public static void main(String[] args) {

        /*
        // 1 Variant
        String input = "Моя дата рождения 2.6.1990";
        Pattern pattern1 = Pattern.compile("[0-6]");
        Matcher matcher1 = pattern1.matcher(input);
        */

        /*
        // 2 Variant
        Pattern pattern1 = Pattern.compile("[0-6]");
        Matcher matcher1 = pattern1.matcher("Моя дата рождения 2.6.1990");
         */

        // 3 Variant
        Matcher matcher1 = Pattern.compile("[0-6]").matcher("Моя дата рождения 2.6.1990");

        while (matcher1.find()) {
            System.out.println("matcher1: " + matcher1.group());
        }


        System.out.println("========Task_2=========");
        /*
        Task 2: Поиск Специальных Символов
        Напишите регулярное выражение, чтобы найти все вхождения символов @ '&', '!' в строке.

        Пример строки: "myemail@example.co!m another&email@example.com"
        Ожидаемый результат: "@", "!", "&", "@"
        */

        Pattern pattern2 = Pattern.compile("[@&!]");
        Matcher matcher2 = pattern2.matcher("myemail@example.co!m another&email@example.com");

        while (matcher2.find()) {
            System.out.println("matcher2: " + matcher2.group());
        }


        System.out.println("========Task_3=========");
        /*
        Task 3: Поиск Больших Букв
        Напишите регулярное выражение, чтобы найти все заглавные буквы в строке.

        Пример строки: "London is the capital of Great Britain."
        Ожидаемый результат: "L", "G", "B"
        */

        Pattern pattern3 = Pattern.compile("[A-Z]");
        Matcher matcher3 = pattern3.matcher("London is the capital of Great Britain.");

        while (matcher3.find()) {
            System.out.println("matcher3: " + matcher3.group());
        }


        System.out.println("========Task_4=========");
        /*
        Task 4: Поиск Букв 'b' и 'B'
        Создайте регулярное выражение для поиска всех вхождений букв 'b' и 'B' в строке.

        Пример строки: "Bears, Bees, and Bunnies are beautiful."
        Ожидаемый результат: "B", "B", "B", "b"
        */

        Pattern pattern4 = Pattern.compile("[bB]");
        Matcher matcher4 = pattern4.matcher("Bears, Bees, and Bunnies are beautiful.");

        while (matcher4.find()) {
            System.out.println("matcher4: " + matcher4.group());
        }


    }//main
}



