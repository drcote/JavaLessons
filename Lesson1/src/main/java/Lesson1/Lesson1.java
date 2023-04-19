package Lesson1;

import java.math.BigDecimal;
import java.util.Arrays;

public class Lesson1 {
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte myByte = 127;
        short myShort = 32767;
        int myInt = 2147483647;
        long myLong = 922337245;
        float myFloat = 8.5f;
        double myDouble = 8.5;
        boolean myBoolean = false;
        char myChar = 'q';
        BigDecimal myDecimal = new BigDecimal("123.030465805496804596845096");
        String myString = "Hello";
        //-----//

        System.out.println(calc(2, 4, 0, 3));
        System.out.println(numberComparison(5, 6));

        numberCheck(7);
        numberCheck(-3);
        numberCheck(0);

        System.out.println(isNegativeNumber(0));

        greetings("Петр");

        isLeapYear(2400);
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    private static int calc(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    private static boolean numberComparison(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20) ? true : false;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    private static void numberCheck(int number) {
        if (number >= 0) {
            System.out.println(number + " - положительное число");
        } else {
            System.out.println(number + " - отрицательное число");
        }
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    private static void greetings(String name) {
        if (name.length() > 0) {
            System.out.println("Привет, " + name);
        } else {
            System.out.println("Имя не задано");
        }
    }

    //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static void isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Год високосный");
                } else {
                    System.out.println("Год не високосный");
                }
            } else {
                System.out.println("Год високосный");
            }
        } else {
            System.out.println("Год не високосный");
        }
    }
}