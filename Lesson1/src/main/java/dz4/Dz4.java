package dz4;

import java.util.Formatter;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dz4 {
    public static void main(String[] args) {
        // 1) Проверить что строка состоит из буквенно-числовых символов и знаков подчеркивания(язык английский)
        String input = "abc123_";
        if (input.matches("^[\\w]+$")) {
            System.out.println("Строка состоит только из буквенно-числовых символов и знаков подчеркивания.");
        } else {
            System.out.println("Строка содержит недопустимые символы.");
        }
        /*
         2) Проверить что строка состоит из английских букв в нижнем регистре, соединенных подчеркиванием
         примеры допустимых записей:
          							java_exercises
          							privet_drug
         пример недопустимых:
          							privet_
          							test
          							Privet_drug
         */
        String input1 = "java_exercises";
        if (input1.matches("^[a-z]+(_[a-z]+)+$")) {
            System.out.println("Строка состоит только из английских букв в нижнем регистре, соединенных подчеркиванием.");
        } else {
            System.out.println("Строка содержит недопустимые символы.");
        }

        // 3) Проверить что строка содержит букву g, но при этом она не является началом, или концом ни одного из слов в строке
        //String input2 = "Some strings contain the letter, but not at the beginning or end of any words.";
        String input2 = "This is a string with g inside but not at the beginning or end of any word";
        Pattern pattern = Pattern.compile("\\b\\w+g\\w+\\b");
        Matcher matcher = pattern.matcher(input2);

        if (matcher.find()) {
            System.out.println("Строка содержит букву g");
        } else {
            System.out.println("Строка не содержит букву g");
        }
        /*
        4) Написать программу извлекающую из текста все html - теги
        пример текста:
        String content = "<p>Hello <code>Everybody</code> nice to meet u " +
            "Hope to see u soon.</p>";
        Должно получиться

        <p>
        <code>
        </code>
        </p>
        */
        String content = "<p>Hello <code>Everybody</code> nice to meet u Hope to see u soon.</p>";

        Pattern pattern1 = Pattern.compile("</?[a-zA-Z]+>");
        Matcher matcher1 = pattern1.matcher(content);

        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }

        /*
        5)Написать программу, проверяющую является ли входная строка email адресом
        e-mail адрес может содержать англ. буквы(любой регистр), .-и, _(подчеркивания) и цифры и '-'(тире)
        до символа @. После символа @ и до (.) - и может содержать буквы, цифры и тире(доменное имя), подчкеркивания не может их в доменах не бывает
        после.-и только 2, или 3 буквы(ru, com итд)
        */
        String input3 = "merezhin@gmail.com";
        if (input3.matches("[\\w-.]+@[a-zA-Z0-9-]+.[a-zA-Z]{2,3}")) {
            System.out.println("Строка является email адресом");
        } else {
            System.out.println("Строка НЕ является email адресом");
        }

        /*
        6) Напишите программу, которая принимает на вход число и выводит его в денежном формате.
        Например, если на вход подается число 1234567.89, то программа должна вывести строку "$1,234,567.89".
        Используйте класс Formatter для форматирования числа и задайте соответствующий шаблон для вывода в денежном формате.
        */
        double number = 1234567.89;
        System.out.println(String.format(Locale.US, "$%,.2f", number));

        /*
        7) Обычный внутренний класс
        Создать класс User, содержащий private переменные login, password.
        Создать внутренний класс Query в классе User. Класс Query содержит метод printToLog(),
        который распечатывает на консоль сообщение о том что пользователь с таким то логином и паролем отправил запрос.
        Класс User, содержит метод createQuery(), в котором создается обьект класса Query и вызывается метод printToLog().
        В методе main(): создать экземпляр класса User и вызвать метод createQuery(); создать экземпляр класса Query и вызвать
        метод printToLog() используя конструкцию new User().new Query()
         */
        User user = new User("Ivan", "qwerty");
        user.createQuery();
        User.Query query = new User("Petr", "123445").new Query();
        query.printToLog();

        /*
        8) Локальный внутренний класс
        Переписать предыдущее задание, используя локальный класс.
        */
        UserLocal userLocal = new UserLocal("Ivan Local", "qwerty");
        userLocal.createQuery();

        /*
        9) Внешний статический класс
        Переписать класс Query используя статический класс.
        */
        UserStatic.Query.printToLog();

        /*
        10) Анонимный класс Printable
        Создать анонимный класс расширяющий интерфейс Printable. Вызвать его метод print().
        */
        Printable printable = new Printable() {
            @Override
            public void print() {
                System.out.println("Anonymous class Printable");
            }
        };
        printable.print();

        /*
        11)Анонимный класс Cookable
        Создать абстрактный класс Cookable, содержащий абстрактный метод void cook(String str).
        Создать класс Food, содержащий метод public void prepare(Cookable c, String str){c.cook(str);}
        Создать экземпляр класса Food и вызвать его метод prepare().
        На вход метода prepare() передать экземпляр анонимного класса расширяющего Cookable.
        */
        Food food = new Food();
        food.prepare(new Cookable() {
            @Override
            public void cook(String str) {
                System.out.println("Cooking " + str);
            }
        }, "burger");

        /*
        12) Есть метод некий допустим просто что-то печатающий и есть ограничение что должен вызваться не чаще 10 раз в минуту, написать эмулятор,
        который с рандомной частотой дергает этот метод, в случае если превышается заданная максимальная частота вызовов,
        метод не должен дергаться, а печатать соответствующее сообщение в лог. В тот раз когда метод не дернулся, из-за превышения лимита,
        считается что он не дернулся. Использовать паттерн декоратор.
        */
        Method realMethod = new RealMethod();
        Method limitedMethod = new LimitedMethod(realMethod, 10, 60000);

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int delay = random.nextInt(1000);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            limitedMethod.call();
        }
    }
}
