## Builder Design Pattern
### Overview

The Builder Pattern is a creational pattern that focuses on separating the construction of a complex object from its representation. It provides an easy-to-implement and refactorable solution for handling complexity in object creation.

## Definition
The main objective of the Builder Pattern is to "Separate the construction of a complex object from its representation so that the same construction process can create multiple different representations." This pattern enables the step-by-step creation of complex objects, ensuring the correct sequence of actions, and ultimately returns a final object with desired values/attributes.

The Builder Pattern creates immutable objects and addresses issues found in the factory design pattern and the Telescoping Constructor Problem (Instead of initializing all constructors, one constructor can utilize already initialized constructors).

Unlike constructors, it allows for optional parameters, and developers can easily add new attributes to a class without affecting the existing codebase.

### Code Explanation
The code demonstrates the implementation of the Builder Design Pattern for creating Immutable User objects with both mandatory and optional parameters. The User class has a private inner class, UserBuilder, which is responsible for constructing User instances.

- **User Class:** Immutable class with final fields and a private constructor.
- **UserBuilder Class:** A private inner class responsible for constructing User instances. It provides methods for setting optional parameters and a `build()` method for constructing the final User object.
- **Client Class:** Demonstrates the usage of the Builder pattern to create User instances with various parameters.
- **toString() Method:** Overridden in the User class to provide a meaningful representation of User objects.

### Class Diagram
```
+------------------------------------+
 |              User                  |
 +------------------------------------+
 | - userId: String                   |
 | - firstName: String                |
 | - lastName: String                 |
 | - age: int                         |
 +------------------------------------+
 | + getUserId(): String              |
 | + getFirstName(): String           |
 | + getLastName(): String            |
 | + getAge(): int                    |
 | + toString(): String               |
 +------------------------------------+
 |          UserBuilder               |
 +------------------------------------+
 | - userId: String                   |
 | - firstName: String                |
 | - lastName: String                 |
 | - age: int                         |
 +------------------------------------+
 | + setUserId(String): UserBuilder   |
 | + setFirstName(String): UserBuilder|
 | + setLastName(String): UserBuilder |
 | + setAge(int): UserBuilder         |
 | + build(): User                    |
 +------------------------------------+
```

In the class diagram:
- The User class represents the immutable User object.
- The UserBuilder class is an inner class of User responsible for constructing
  User objects with optional parameters.
- Arrows represent relationships, and the - indicates private members/methods,
  while + indicates public members/methods.
- The build method in UserBuilder constructs the final User object with the provided
  or default values.


### Summary

The design pattern enhances readability and flexibility in creating User objects by allowing the step-by-step construction of complex objects. It ensures the final object is created with the desired values and attributes.

This pattern is particularly useful when developers need to add new attributes to a class. Enclosing the builder inside the class makes it obvious that the builder needs updating, improving maintainability.
