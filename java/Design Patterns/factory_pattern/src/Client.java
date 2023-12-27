import java.util.function.Supplier;

public class Client {
    public static void main(String[] args) {
        // Use of Supplier functional interface
        Supplier<Employee> angularDeveloperSupplier = () -> EmployeeFactory.getEmployee("Angular Developer");
        printSalary("Angular Developer", angularDeveloperSupplier);
        
        Supplier<Employee> javaDeveloperSupplier = () -> EmployeeFactory.getEmployee("Java Developer");
        printSalary("Java Developer", javaDeveloperSupplier);
        
        Supplier<Employee> androidDeveloperSupplier = () -> EmployeeFactory.getEmployee("Android Developer");
        printSalary("Android Developer", androidDeveloperSupplier);
    }

    // Method to print the salary
    private static void printSalary(String employeeType, Supplier<Employee> employeeSupplier) {
        Employee employee = employeeSupplier.get();
        if (employee != null) {
            int salary = employee.salary();
            System.out.printf("Salary for %s: %d\n", employeeType, salary);
        } else {
            System.out.printf("Employee %s does not exist.\n", employeeType);
        }
    }
}
