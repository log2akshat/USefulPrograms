
public class AndroidDeveloper implements Employee {

	@Override
	public String getName() {
		System.out.println("I am Android Developer");
		return "Android Developer";
	}

	@Override
	public int getSalary() {
		return 50000;
	}

}
