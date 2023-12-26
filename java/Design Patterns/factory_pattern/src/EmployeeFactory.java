public class EmployeeFactory {

    public static Employee getEmployee(String employeeType) {
        if (employeeType.trim().equalsIgnoreCase("ANGULAR DEVELOPER")) {
            return new AngularDeveloper();
        } else if (employeeType.trim().equalsIgnoreCase("JAVA DEVELOPER")) {
            return new JavaDeveloper();
        } else {
            return null;
        }
    }
}
