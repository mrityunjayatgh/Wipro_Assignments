package Day_4Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeOperations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR", 6000),
                new Employee(2, "Bob", "IT", 4000),
                new Employee(3, "Charlie", "IT", 7000),
                new Employee(4, "David", "HR", 4500),
                new Employee(5, "Eve", "Finance", 8000)
        );

        // 1. Find Employee with Highest Salary
        Employee highestSalaryEmployee = employees.stream()
                .max(Comparator.comparingDouble(e -> e.salary))
                .orElse(null);
        System.out.println("1. Highest Salary Employee: " + highestSalaryEmployee);

        // 2. Filter Employees with Salary Greater Than 5000
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.salary > 5000)
                .toList();
        System.out.println("2. Filtered Employees (Salary > 5000): " + filteredEmployees);

        // 3. Get Employee Names and Salaries
        List<String> nameSalaryList = employees.stream()
                .map(e -> "{Name: " + e.name + ", Salary: " + e.salary+"}")
                .toList();
        System.out.println("3. Employee Names and Salaries: " + nameSalaryList);

        // 4. Count Employees
        long employeeCount = employees.stream().count();
        System.out.println("4. Total Employees Count: " + employeeCount);

        // 5. Group Employees by Department
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));
        System.out.println("5. Employees Grouped by Department: " + employeesByDepartment);

        // 6. Calculate Average Salary
        double averageSalary = employees.stream()
                .mapToDouble(e -> e.salary)
                .average()
                .orElse(0);
        System.out.println("6. Average Salary: " + averageSalary);

        // 7. Sort Employees by Salary
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.salary))
                .toList();
        System.out.println("7. Sorted Employees by Salary: " + sortedBySalary);

        // 8. Find Employee with Second Highest Salary
        Employee secondHighestSalaryEmployee = employees.stream()
                .sorted(Comparator.comparingDouble(e -> -e.salary))
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("8. Second Highest Salary Employee: " + secondHighestSalaryEmployee);

        // 9. Partition Employees by Salary Threshold
        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary > 5000));
        System.out.println("9. Partitioned Employees by Salary > 5000: " + partitionedBySalary);

        // 10. Find Employee with Longest Name
        Employee longestNameEmployee = employees.stream()
                .max(Comparator.comparingInt(e -> e.name.length()))
                .orElse(null);
        System.out.println("10. Longest Name Employee: " + longestNameEmployee);

        // 11. Group Employees by Department and Calculate Average Salary
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department,
                        Collectors.averagingDouble(e -> e.salary)));
        System.out.println("11. Average Salary by Department: " + avgSalaryByDept);

        // 12. Find Top 3 Highest Paid Employees
        List<Employee> top3HighestPaid = employees.stream()
                .sorted(Comparator.comparingDouble(e -> -e.salary))
                .limit(3)
                .toList();
        System.out.println("12. Top 3 Highest Paid Employees: " + top3HighestPaid);

        // 13. Calculate Total Salary of All Employees Using Reduce
        double totalSalary = employees.stream()
                .map(e -> e.salary)
                .reduce(0.0, Double::sum);
        System.out.println("13. Total Salary of All Employees: " + totalSalary);
    }
}
