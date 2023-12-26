public class Client {
    public static void main(String[] args) {
        Employee employee1 = EmployeeFactory.getEmployee("Angular Developer");
        int salary1 = employee1.salary();
        System.out.printf("Salary: %d\n", salary1);
        
        Employee employee2 = EmployeeFactory.getEmployee("Java Developer");
        int salary2 = employee2.salary();
        System.out.printf("Salary: %d\n", salary2);
        
        Employee employee3 = EmployeeFactory.getEmployee("Android Developer");
    }
}
