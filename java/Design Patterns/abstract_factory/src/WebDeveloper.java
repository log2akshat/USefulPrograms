
public class WebDeveloper implements Employee {

	@Override
	public String getName() {
		System.out.println("I am Web Developer");
		return "Web Developer";
	}

	@Override
	public int getSalary() {
		return 90000;
	}

}
