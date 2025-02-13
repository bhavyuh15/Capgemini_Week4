package mapinterface.groupbydepartment;


import java.util.*;
import java.util.stream.Collectors;

public class GroupByDepartment {
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        // Grouping by department
        Map<String, List<Employee>> groupedByDept = groupByDepartment(employees);
        System.out.println(groupedByDept);  // Output: {HR=[Alice, Carol], IT=[Bob]}
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

