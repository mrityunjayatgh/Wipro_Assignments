package Day_2;

import java.util.ArrayList;
import java.util.Scanner;

// Base class for Employee
class Employee {
    private String id;
    private String name;
    private String department;
    private double baseSalary;

    public Employee(String id, String name, String department, double baseSalary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Base Salary: " + baseSalary;
    }
}

// Subclass for Permanent Employee
class PermanentEmployee extends Employee {
    private double bonus;

    public PermanentEmployee(String id, String name, String department, double baseSalary, double bonus) {
        super(id, name, department, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Bonus: " + bonus + ", Total Salary: " + calculateSalary();
    }
}

// Subclass for Contractual Employee
class ContractualEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public ContractualEmployee(String id, String name, String department, double baseSalary, int hoursWorked, double hourlyRate) {
        super(id, name, department, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }

    @Override
    public String toString() {
        return super.toString() + ", Hours Worked: " + hoursWorked + ", Hourly Rate: " + hourlyRate + ", Total Salary: " + calculateSalary();
    }
}

// Payroll system to manage employees
public class EmployeePayrollSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();

    private static void addPermanentEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Base Salary: ");
        double baseSalary = scanner.nextDouble();
        System.out.print("Enter Bonus: ");
        double bonus = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        employees.add(new PermanentEmployee(id, name, department, baseSalary, bonus));
        System.out.println("Permanent Employee added successfully!");
    }

    private static void addContractualEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Base Salary: ");
        double baseSalary = scanner.nextDouble();
        System.out.print("Enter Hours Worked: ");
        int hoursWorked = scanner.nextInt();
        System.out.print("Enter Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        employees.add(new ContractualEmployee(id, name, department, baseSalary, hoursWorked, hourlyRate));
        System.out.println("Contractual Employee added successfully!");
    }

    private static void generatePayrollReport() {
        System.out.println("\n--- Payroll Report ---");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Payroll System ---");
            System.out.println("1. Add Permanent Employee");
            System.out.println("2. Add Contractual Employee");
            System.out.println("3. Generate Payroll Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPermanentEmployee(scanner);
                    break;
                case 2:
                    addContractualEmployee(scanner);
                    break;
                case 3:
                    generatePayrollReport();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
