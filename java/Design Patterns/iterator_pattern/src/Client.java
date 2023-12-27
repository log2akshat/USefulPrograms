class Client {
    public static void main(String[] args) {

        EmployeeManagement employeeManagement = new EmployeeManagement();
        employeeManagement.addEmployee(new Employee("01", "Akshat", 20000));
        employeeManagement.addEmployee(new Employee("02", "Rajiv", 30000));
        employeeManagement.addEmployee(new Employee("03", "Diwakar", 40000));
        employeeManagement.addEmployee(new Employee("04", "Mahendra", 50000));
        employeeManagement.addEmployee(new Employee("04", "Bollapragada", 60000));
        
        MyIterator myIterator = employeeManagement.getIterator();
        while (myIterator.hasNext()) {
            Employee employee = (Employee) myIterator.next();
            System.out.println(employee.getEmployeeName());
        }
    }
}