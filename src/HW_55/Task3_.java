package HW_55;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 27.11.2023
 * Menu
 *
 * @author Mihail nedioglo (AIT TR)
 */
/*
Дан список Employee. Вычислите среднюю зарплату сотрудников в каждом отделе
и найдите отдел с максимальной средней зарплатой.
 */
public class Task3_ {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 5000),
                new Employee("Bob", "IT", 6000),
                new Employee("Charlie", "HR", 7500),
                new Employee("Alice", "Finance", 7000),
                new Employee("David", "IT", 8000)
        );

// Вычислить среднюю зарплату по отделам
        Map<String,Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

       // System.out.println("Средняя зарплата по отделам: " + averageSalaryByDepartment);
        averageSalaryByDepartment.forEach((department, averageSalary) -> {
            System.out.println("Department-отдел : " + department);
            System.out.println("  Average Salary-Средняя заработная плата: " + averageSalary);
        });

// Найти отдел с максимальной средней зарплатой
        String departmentWithMaxSalary = averageSalaryByDepartment.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Отдел с максимальной средней зарплатой: " + departmentWithMaxSalary);


    }
}
