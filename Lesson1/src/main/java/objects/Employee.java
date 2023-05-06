package objects;

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

    @Override
    public String toString() {
        return "fio: " + this.fio + "position: " + this.position + "email: " + this.email + "tel: " + this.tel + "salary: " + this.salary + "age: " + this.age;
    }
}