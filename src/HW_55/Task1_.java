package HW_55;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mihail Nedioglo
 * @data 24.11.2023
 */
/*
Дан список сотрудников (Employee) с полями name, department, salary.
Используя Stream API, сгруппируйте сотрудников по отделам
*/

public class Task1_ {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Иван", "Отдел разработки", 6000),
                new Employee("Мария", "Отдел маркетинга", 5000),
                new Employee("Петр", "Отдел разработки", 7500),
                new Employee("Анна", "Отдел продаж", 4500)
        );

        // Группировка сотрудников по отделам

        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDepartment.forEach((department, employeeList) -> {
            System.out.println("Department: " + department);
            employeeList.forEach(employee -> System.out.println("  " + employee.getName()));
        });


    }//main
}
