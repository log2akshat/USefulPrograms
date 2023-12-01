
public class Client {
	
	public static void main(String[] args) {
		Employee e1 = EmployeeFactory.getEmployee(new WebDevFactory());
		e1.getName();

		Employee e2 = EmployeeFactory.getEmployee(new AndroidDevFactory());
		e2.getName();

		Employee e3 = EmployeeFactory.getEmployee(new JavaDevFactory());
		e3.getName();
	}

}
