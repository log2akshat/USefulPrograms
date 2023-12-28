# Design Patterns that Follow SOLID Principles

## S: Single Responsibility Principle (SRP)

The Single Responsibility Principle (SRP) is a key SOLID principle that emphasizes that a class should have only one reason to change, meaning it should have a single, well-defined responsibility. Class should have only 1 reason to change.

## O: Open/Closed Principle

The Open/Closed Principle (OCP) states that a class should be open for extension but closed for modification. Design patterns that adhere to the Open/Closed Principle typically provide a way to add new functionality or behavior without altering existing code.

## L: Liskov Substitution Principle

The Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In other words, a derived class should extend the functionality of the base/parent class without changing its behavior not narrowing it down. Design patterns that adhere to the Liskov Substitution Principle ensure that derived classes can be used interchangeably with their base/parent classes.

## I: Interface Segregation Principle

The Interface Segregation Principle (ISP) emphasizes that a class should not be forced to implement interfaces it does not use. Design patterns aligned with ISP contribute to creating interfaces tailored to the specific needs of implementing classes. 

## Dependency Inversion Principle

The Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules but both should depend on abstractions. Abstractions should not depend on details; rather, details should depend on abstractions (Classes should depend on interfaces rather than concrete classes).

---

## Design patterns that naturally align with the SOLID Principles:

#### 1. Factory Method Pattern:
- **Responsibility:** Defines an interface for creating an object but leaves the choice of its type to the subclasses, creating an instance of several possible derived classes.
- **SRP Alignment:** The factory method in each subclass has the responsibility of creating an instance of a specific class.
- **OCP Alignment:** Subclasses can extend the framework by providing their own implementations.
- **LSP Alignment:** Allows the client code to use the factory method without being concerned about the concrete class being created.
- **DIP Alignment:** High-level modules depend on the factory method interface, and low-level modules provide concrete factory implementations.


#### 2. Abstract Factory Pattern:
- **Responsibility:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **SRP Alignment:** Each concrete factory class has the responsibility of creating a family of related objects. Each product class has the responsibility of defining its behavior.
- **OCP Alignment:** New families of objects can be added by introducing new concrete factories.
- **LSP Alignment:** Clients can use the abstract factory interface to create objects without being aware of the specific implementations.
- **DIP Alignment:** High-level modules depend on the abstract factory interface, and low-level modules provide concrete factory implementations.


#### 3. Strategy Pattern:
- **Responsibility:** Defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable.
- **SRP Alignment:** Each strategy class has the responsibility of implementing a specific algorithm. The context class (that uses the strategy) has the responsibility of using the strategy.
- **OCP Alignment:** New strategies can be added without modifying the context that uses them.
- **LSP Alignment:** Subclasses can provide their own implementations of algorithms, ensuring that they can be used interchangeably with the base algorithm.
- **ISP Alignment:** Concrete strategy classes implement only the methods relevant to their specific algorithm.
- **DIP Alignment:** High-level modules can depend on an abstraction (strategy interface) while low-level modules provide concrete implementations.


#### 4. Observer Pattern:
- **Responsibility:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **SRP Alignment:** The subject class (the one being observed) is responsible for managing its observers. The observer classes are responsible for reacting to changes.
- **OCP Alignment:** Defines a one-to-many dependency between objects, allowing a subject to notify its observers of changes without modifying the observers.
- **ISP Alignment:** Observer interfaces can include only the methods relevant to the observed events.
- **DIP Alignment:** High-level modules can depend on an observer interface, and low-level modules can implement the interface.


#### 5. Adapter Pattern:
- **Responsibility:** Allows the interface of an existing class to be used as another interface.
- **SRP Alignment:** The adapter class has the responsibility of adapting the interface of one class to another. The adapted class has the responsibility of providing its original functionality.
- **ISP Alignment:** The Adapter pattern lets a class implement only the methods it needs from the adapted interface.
- **DIP Alignment:** AHigh-level modules depend on an adapter interface, and low-level modules provide concrete adapter implementations.


#### 6. Proxy Pattern:
- **Responsibility:** Provides a surrogate or placeholder for another object to control access to it.
- **SRP Alignment:** The proxy class has the responsibility of controlling access to the real subject. The real subject has the responsibility of providing the actual functionality.


#### 7. Chain of Responsibility Pattern:
- **Responsibility:** Passes the request along a chain of handlers. Each handler decides to process the request or pass it to the next handler.
- **SRP Alignment:** Each handler in the chain has the responsibility of deciding whether to handle the request or pass it to the next handler.
- **LSP Alignment:** Each handler in the chain should be able to handle the request or pass it to the next handler without affecting the behavior of the entire chain.
- **ISP Alignment:** Handlers in the chain can implement only the methods necessary for handling the specific requests they are responsible for.


#### 8. Iterator Pattern:
- **Responsibility:** Provides a way to access elements of an aggregate object sequentially without exposing its underlying representation.
- **LSP Alignment:** Subclasses of the iterator can be used interchangeably without affecting the client code.


#### 9. Dependency Injection (DI) / Inversion of Control (IoC) Container:
- **Responsibility:** Inverts the control of object creation and provides instances of classes to dependent objects.
- **DIP Alignment:** Achieves loose coupling by allowing higher-level modules to depend on abstractions (interfaces) instead of concrete implementations.


#### 10. Command Query Responsibility Segregation (CQRS):
- **Responsibility:** Separates the responsibility for handling command input from the responsibility for handling query output.
- **SRP Alignment:** Command handlers are responsible for handling commands, and query handlers are responsible for handling queries.
- **OCP Alignment:** It allows the system to be extended with new commands and queries without modifying existing code.
- **ISP Alignment:** Command handlers and query handlers can have distinct interfaces tailored to their specific tasks.


#### 11. Command Pattern:
- **Responsibility:** Encapsulates a request as an object, allowing for parameterization, queuing, and logging of requests.
- **SRP Alignment:** Command classes have the responsibility of encapsulating a specific operation. The invoker class has the responsibility of invoking the command.
- **OCP Alignment:** New command classes can be added without modifying the invoker.
- **LSP Alignment:** Command subclasses can be used interchangeably with the base command class.
- **ISP Alignment:** Command interfaces can be tailored to include only the necessary methods.
- **DIP Alignment:** High-level modules can depend on command interfaces, and low-level modules can provide concrete command implementations.


#### 12. Decorator Pattern:
- **Responsibility:** Attaches additional responsibilities to an object dynamically. Provides a flexible alternative to subclassing for extending functionality.
- **SRP Alignment:** Each decorator class has the responsibility of adding a specific behavior to the component it decorates. The core component class has the responsibility of providing the base functionality.
- **OCP Alignment:** We can introduce new decorators to add functionality to the existing set of components without modifying them.
- **LSP Alignment:** Decorators conform to the same interface as the components they decorate, ensuring that they can be used interchangeably.
- **ISP Alignment:** Decorators conform to a common interface, and concrete decorators implement only the methods they need.
- **DIP Alignment:** High-level modules depend on a component interface, and decorators implement the same interface.


#### 13. Template Method Pattern:
- **Responsibility:** Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm.
- **OCP Alignment:** Open/Closed Principle is aligned by allowing the structure of an algorithm to be defined in a superclass while allowing its steps to be extended or overridden by subclasses without modifying the overall algorithm.
- **LSP Alignment:** Subclasses should be able to substitute their implementations without affecting the algorithm's structure.
- **DIP Alignment:** High-level modules depend on an abstract template method, and low-level modules provide concrete implementations.


#### 14. State Pattern:
- **Responsibility:** Allows an object to alter its behavior when its internal state changes. 
- **OCP Alignment:** New states can be added without modifying existing state classes.
- **LSP Alignment:** States can be added or replaced without affecting the client code using the context class.


#### 15. Visitor Pattern:
- **Responsibility:** Represents an operation to be performed on the elements of an object structure.
- **OCP Alignment:** It allows defining new operations without changing the classes of the elements on which it operates.
- **ISP Alignment:** Visitors can define interfaces with methods for specific elements, and concrete visitors implement only the methods they need.


#### 16. Specification Pattern:
- **Responsibility:** Behavioral design pattern that enables the definition of complex business rules as separate, composable objects, allowing clients to filter or select objects based on these rules.
- **OCP Alignment:** Defines a set of criteria for objects, and allows combining these criteria to create new specifications without modifying existing ones.


#### 17. Composite Pattern:
- **Responsibility:** Composes objects into tree structures to represent part-whole hierarchies. 
- **LSP Alignment:** Components (leaves and composites) should be interchangeable, allowing clients to treat individual objects and compositions uniformly.
- **ISP Alignment:** Component interfaces can be designed to include only methods relevant to both leaves and composites.


#### 18. Bridge Pattern:
- **Responsibility:** Separates abstraction from implementation, allowing them to vary independently.
- **ISP Alignment:** Clients can use only the abstraction interface relevant to them, avoiding the need to implement unnecessary methods.
- **DIP Alignment:** Abstractions and implementations are kept separate, and high-level modules depend on abstractions.


## Summary
Applying these design patterns with a focus on the SOLID Principles helps create modular and maintainable systems by promoting the use of abstractions and reducing direct dependencies on concrete implementations. This leads to flexible and extensible designs that are easier to test and maintain.

SOLID Principles avoids duplications of code, they are easy to maintain and understand providing a flexible software and reduces complexity.

