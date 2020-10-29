package lesson_5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HW5 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иванов Иван", "Сантехник",
                        "ivanov@mail.com", "8916161616", 35000, 35),
                new Employee("Сальников Александр", "Старший Сантехник",
                        "salnikov@mail.com", "89167226545", 45000, 45),
                new Employee("Васильев Василий", "Прорабt",
                        "vasilev@mail.com", "89111113456", 55000, 41),
                new Employee("Сидоров Василий", "Ассистент",
                        "sidorov@mail.com", "89178364546", 25000, 19),
                new Employee("Сергеев Сергей", "Водитель",
                        "sergeev@mail.com", "89177465758", 39000, 39)
        };

        for (Employee employee : employees)
            if (employee.getAge() > 40)
                System.out.println(employee);

        try (FileWriter file = new FileWriter("employee.txt")) {
            for (Employee employee : employees)
                file.write(employee.getDataInCSV() + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("employee.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        int index = 0;
        employees = new Employee[lines.size()];
        for (String line : lines) {
            String[] field = line.split(",");
            employees[index] = new Employee(
                    field[0], field[1], field[2], field[3],
                    Integer.parseInt(field[4]), Integer.parseInt(field[5]));
            index++;
        }
    }
}

class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone,
                    int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getDataInCSV() {
        return name + "," + position + "," + email + "," + phone + "," +
                salary + "," + age;
    }

    @Override
    public String toString() {
        return (name +
                "\n| Position: " + position +
                "\n| Email: " + email +
                "\n| Phone: " + phone +
                "\n| Salary: " + salary +
                "\n| Age: " + age);
    }
}

