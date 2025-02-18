import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void displayEmployeeDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManager {

    static ArrayList<Employee> employees = new ArrayList<>();
    public static void addEmployee(int id, String name, double salary) {
        Employee newEmployee = new Employee(id, name, salary);
        employees.add(newEmployee);
        System.out.println("Employee added successfully.");
    }
    public static void updateEmployee(int id, String newName, double newSalary) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                employee.name = newName;
                employee.salary = newSalary;
                System.out.println("Employee details updated.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    public static void removeEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                employees.remove(employee);
                System.out.println("Employee removed.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    public static void searchEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                employee.displayEmployeeDetails();
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    public static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            for (Employee employee : employees) {
                employee.displayEmployeeDetails();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee by ID");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double addSalary = scanner.nextDouble();
                    addEmployee(addId, addName, addSalary);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Employee Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Employee Salary: ");
                    double newSalary = scanner.nextDouble();
                    updateEmployee(updateId, newName, newSalary);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    removeEmployee(removeId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    searchEmployee(searchId);
                    break;

                case 5:
                    displayAllEmployees();
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
