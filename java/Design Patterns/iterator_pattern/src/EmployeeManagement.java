import java.util.ArrayList;

public class EmployeeManagement {

    private ArrayList<Employee> employeesList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeesList.add(employee);
    }

    public Employee getEmployee(int index) {
        return employeesList.get(index);
    }

    // Obtain an iterator for the employee list
    public MyIterator getIterator() {
        return new MyIteratorImpl(employeesList);
    }
}
