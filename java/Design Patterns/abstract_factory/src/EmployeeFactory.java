
public class EmployeeFactory {
	
	// return Employee
	public static Employee getEmployee(EmployeeAbstractFactory factory) {
		return factory.createEmployee();
	}

}
