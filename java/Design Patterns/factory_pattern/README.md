# Factory Method Design Pattern

The Factory Method Design Pattern proves to be beneficial when creating objects that share the same categorization but exhibit different properties. It ensures abstraction, provides flexibility and adaptability, and is particularly valuable for frameworks and libraries. This pattern helps in concealing complexity; however, it's important to note that it's not easily refactored. Therefore, it requires careful planning during implementation.


## Explanation of the Factory Method Design Pattern Code

The code comprises a functional interface `Employee.java`, a factory class `EmployeeFactory.java` responsible for creating `Employee` objects based on the specified `Employee` type, and distinct concrete classes `AngularDeveloper.java` and `JavaDeveloper.java` that implement the `Employee` interface.

### EmployeeFactory Class
`EmployeeFactory` class by leverages the Java 8 functional interfaces. It utilizes a Map of employee types and Suppliers, employing method references for object creation. The `getEmployee()` method retrieves the Supplier from the Map.

- It contains static `Map<String, Supplier<Employee>> employeeMap`.
- Method references are used for object creation (`AngularDeveloper::new` and `JavaDeveloper::new`).
- Code has improved extensibility for adding new employee types.

### Client Class

`Client` class takes advantage of Java 8's Supplier functional interface when obtaining employees from the `EmployeeFactory`. It aligns with functional programming principles through the use of lambda expressions.

Additionally, a generic method `printSalary()` is used to facilitate the printing of employee salaries for various employee types.
