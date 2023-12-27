import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EmployeeFactory {

    private static final Map<String, Supplier<Employee>> employeeMap = new HashMap<>();

    static {
        employeeMap.put("ANGULAR DEVELOPER", AngularDeveloper::new);
        employeeMap.put("JAVA DEVELOPER", JavaDeveloper::new);
    }

    public static Employee getEmployee(String employeeType) {
        return employeeMap.getOrDefault(employeeType.trim().toUpperCase(), () -> null).get();
    }
}
