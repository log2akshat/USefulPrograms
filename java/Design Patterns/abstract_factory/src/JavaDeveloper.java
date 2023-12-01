
public class JavaDeveloper implements Employee {

	@Override
	public String getName() {
		System.out.println("I am Java Developer");
		return "Java Developer";
	}

	@Override
	public int getSalary() {
		return 150000;
	}

}
