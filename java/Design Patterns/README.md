# Design Patterns that Follow SOLID Principles

## S: Single Responsibility Principle (SRP)

The Single Responsibility Principle (SRP) is a key SOLID principle that emphasizes that a class should have only one reason to change, meaning it should have a single, well-defined responsibility. Class should have only 1 reason to change.

## O: Open/Closed Principle

The Open/Closed Principle (OCP) states that a class should be open for extension but closed for modification. Design patterns that adhere to the Open/Closed Principle typically provide a way to add new functionality or behavior without altering existing code.

## Design patterns that naturally align with the SOLID Principles:

#### 1. Factory Method Pattern:
- **Responsibility:** Defines an interface for creating an object but leaves the choice of its type to the subclasses, creating an instance of several possible derived classes.
- **SRP Alignment:** The factory method in each subclass has the responsibility of creating an instance of a specific class.
- **OCP Alignment:** Subclasses can extend the framework by providing their own implementations.

#### 2. Abstract Factory Pattern:
- **Responsibility:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **SRP Alignment:** Each concrete factory class has the responsibility of creating a family of related objects. Each product class has the responsibility of defining its behavior.
- **OCP Alignment:** New families of objects can be added by introducing new concrete factories.

#### 3. Strategy Pattern:
- **Responsibility:** Defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable.
- **SRP Alignment:** Each strategy class has the responsibility of implementing a specific algorithm. The context class (that uses the strategy) has the responsibility of using the strategy.
- **OCP Alignment:** New strategies can be added without modifying the context that uses them.

#### 4. Observer Pattern:
- **Responsibility:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **SRP Alignment:** The subject class (the one being observed) is responsible for managing its observers. The observer classes are responsible for reacting to changes.
- **OCP Alignment:** Defines a one-to-many dependency between objects, allowing a subject to notify its observers of changes without modifying the observers.

#### 5. Adapter Pattern:
- **Responsibility:** Allows the interface of an existing class to be used as another interface.
- **SRP Alignment:** The adapter class has the responsibility of adapting the interface of one class to another. The adapted class has the responsibility of providing its original functionality.

#### 6. Proxy Pattern:
- **Responsibility:** Provides a surrogate or placeholder for another object to control access to it.
- **SRP Alignment:** The proxy class has the responsibility of controlling access to the real subject. The real subject has the responsibility of providing the actual functionality.

#### 7. Chain of Responsibility Pattern:
- **Responsibility:** Passes the request along a chain of handlers. Each handler decides to process the request or pass it to the next handler.
- **SRP Alignment:** Each handler in the chain has the responsibility of deciding whether to handle the request or pass it to the next handler.

#### 8. Command Query Responsibility Segregation (CQRS):
- **Responsibility:** Separates the responsibility for handling command input from the responsibility for handling query output.
- **SRP Alignment:** Command handlers are responsible for handling commands, and query handlers are responsible for handling queries.
- **OCP Alignment:** It allows the system to be extended with new commands and queries without modifying existing code.

#### 9. Command Pattern:
- **Responsibility:** Encapsulates a request as an object, allowing for parameterization, queuing, and logging of requests.
- **SRP Alignment:** Command classes have the responsibility of encapsulating a specific operation. The invoker class has the responsibility of invoking the command.
- **OCP Alignment:** New command classes can be added without modifying the invoker.

#### 10. Decorator Pattern:
- **Responsibility:** Attaches additional responsibilities to an object dynamically. Provides a flexible alternative to subclassing for extending functionality.
- **SRP Alignment:** Each decorator class has the responsibility of adding a specific behavior to the component it decorates. The core component class has the responsibility of providing the base functionality.
- **OCP Alignment:** We can introduce new decorators to add functionality to the existing set of components without modifying them.


#### 11. Template Method Pattern:
   - **OCP Alignment:** Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

#### 12. State Pattern:
- **Responsibility:** Allows an object to alter its behavior when its internal state changes. 
- **OCP Alignment:** New states can be added without modifying existing state classes.

#### 13. Visitor Pattern:
- **Responsibility:** Represents an operation to be performed on the elements of an object structure.
- **OCP Alignment:** It allows defining new operations without changing the classes of the elements on which it operates.

#### 14. Specification Pattern:
- **Responsibility:** Behavioral design pattern that enables the definition of complex business rules as separate, composable objects, allowing clients to filter or select objects based on these rules.
- **OCP Alignment:** Defines a set of criteria for objects, and allows combining these criteria to create new specifications without modifying existing ones.

