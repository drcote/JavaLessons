package dz5;

import dz4.User;

import java.util.ArrayList;
import java.util.List;

public class Dz5 {
    public static void main(String[] args) throws InterruptedException {
//        1) Написать программу эммулирующую ошибку OutOfMemory, чтобы она наступила раньше нужно использовать параметры JVM при запуске программы влияющие на максимальный
//        размер Heap-а допустимого при работе программы. При работе программы использовать обьекты нескольких типов. В момент падения программы необходимо чтобы она сохранила
//        файл heap dump. Проанализировать heap dump с помощью VisualVM, определить какие из обьектов привели к наибольшей потери памяти.
//        outOfMemory();

//        2) Написать программу приводящую к периодической работе Garbage Collector-а(Генерация обьктов ссылки на которые освобождаются). При запуске с помощью параметров добиться
//        чтобы программа писала log garbage collector-а. По результатам работы программы определить через лог когда сработал GC и сколько памяти при каждом запуске было освобождено.
        outOfMemoryGarbageCollector();
    }

    private static void outOfMemory() {
        List<Integer> list = new ArrayList<>();

        try {
            while (true) {
                list.add(1);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory error");
        }
    }

    private static void outOfMemoryGarbageCollector() throws InterruptedException {
        User user = null;

        for (int i = 1; i < 1000000; i++) {
            Thread.currentThread().sleep(1);

            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");
            user = new User("qaz", "123");

        }
    }
}
