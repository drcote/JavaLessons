package Objects;

import java.util.stream.Stream;

public class Objects {
    public static void main(String[] args) {
        /*
         * Создать массив из 5 сотрудников;
         * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
         */
//        Employee[] employesArray = new Employee[5];
//        employesArray[0] = new Employee("Фомин Кондрат Александрович", "Программист", "fomin@fomin.ru", "7143181993", 3500, 45);
//        employesArray[1] = new Employee("Фёдоров Осип Павлович", "Менеджер", "fedorov@fedorov.ru", "778125360660", 4800, 39);
//        employesArray[2] = new Employee("Константинов Павел Пантелеймонович", "Продавец", "konstantinov@konstantinov.ru", "763118393124", 7890, 40);
//        employesArray[3] = new Employee("Мышкин Дмитрий Михайлович", "Врач", "mishkin@mishkin.ru", "7437376500", 5432, 28);
//        employesArray[4] = new Employee("Фёдоров Назарий Яковович", "Лифтёр", "fedorov1@fedorov.ru", "7470420052", 5098, 42);

//        for (Employee employee : employesArray) {
//            if (employee.getAge() > 40) {
//                System.out.println(employee.toString());
//            }
//        }
        Stream<Employee> employesStream = Stream.of(new Employee("Фомин Кондрат Александрович", "Программист", "fomin@fomin.ru", "7143181993", 3500, 45), new Employee("Фёдоров Осип Павлович", "Менеджер", "fedorov@fedorov.ru", "778125360660", 4800, 39), new Employee("Константинов Павел Пантелеймонович", "Продавец", "konstantinov@konstantinov.ru", "763118393124", 7890, 40), new Employee("Мышкин Дмитрий Михайлович", "Врач", "mishkin@mishkin.ru", "7437376500", 5432, 28), new Employee("Фёдоров Назарий Яковович", "Лифтёр", "fedorov1@fedorov.ru", "7470420052", 5098, 42));
        employesStream.filter(employee -> employee.getAge() > 40).forEach(employee -> System.out.println(employee.toString()));
        /*
         * 1. Создать классы Собака и Кот с наследованием от класса Животное.
         * 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
         * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
         * 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
         * 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
         */

        Animal cat = new Cat();
        cat.run(200);
        cat.jump(2);
        cat.swim(2);

        Animal dog = new Dog();
        dog.run(400);
        dog.jump(0.7f);
        dog.swim(9);

        Animal dog1 = new Dog(400, 0.5f, 10);
        dog1.run(399);
        dog1.run(401);

        Animal dog2 = new Dog(600, 0.5f, 10);
        dog2.run(599);
        dog2.run(601);


        System.out.println(numberToStringConversion("00000000", (short) 12));

        Animal dog3 = new Dog(600, 0.5f, 10);

        System.out.println(dog2.equals(dog3));
        System.out.println(dog2.hashCode());
        System.out.println(dog3.hashCode());
    }

    /*
    Есть маска фиксированного размера из "00000000", как входной параметр подается число, от 1 до 10000
   нужно дополнить число нулями слева до размера маски, например если на вход подали 123 должно получиться: "00000123"
   имеет практическое применение при сохранении файлов с логами в виде 1.txt, 2.txt, ..., 10.txt, при сортировке по наименованию
   файл 10.txt оказывается раньше чем 2.txt, добавление маски исправляет эту ситуацию
    */
    public static String numberToStringConversion(String mask, short number) {
        if (number >= 1 && number <= 10000) {
            String str = mask + number;
            return str.substring(str.length() - mask.length());
        }
        return "Число в не заданных пределов";
    }
}
