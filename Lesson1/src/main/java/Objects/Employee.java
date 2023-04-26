package Objects;

/*
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 */
public class Employee {
    private String fio;
    private String position;
    private String email;
    private String tel;
    private int salary;
    private int age;

    public Employee(String fio, String position, String email, String tel, int salary, int age) {
        this.age = age;
        this.email = email;
        this.fio = fio;
        this.tel = tel;
        this.position = position;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void presentation() {
        System.out.println("fio: " + this.fio);
        System.out.println("position: " + this.position);
        System.out.println("email: " + this.email);
        System.out.println("tel: " + this.tel);
        System.out.println("salary: " + this.salary);
        System.out.println("age: " + this.age);
    }
}