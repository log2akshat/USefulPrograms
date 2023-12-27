# Iterator Design Pattern

The Iterator Design Pattern is a behavioral pattern that provides a way to access the elements of an object without exposing its underlying implementation. This pattern is commonly used to traverse a collection of elements without exposing the internal details of the collection.

## Intent

The main intent of the Iterator Pattern is to define a way to traverse a collection of objects without exposing the details of the collection's implementation. By providing a standardized interface for traversing elements, the pattern promotes the separation of concerns and allows clients to iterate over a collection without being dependent on its internal structure.

## Key Components

1. **Iterator Interface:**
   - Declares the methods for traversing the collection.

2. **Concrete Iterator:**
   - Implements the Iterator Interface and keeps track of the current position in the traversal.

3. **Aggregate Interface:**
   - Declares the methods for creating iterators.

4. **Concrete Aggregate:**
   - Implements the Aggregate Interface and provides the actual collection of elements.

5. **Client:**
   - Utilizes the Iterator and Aggregate interfaces to traverse the collection without being aware of its internal representation.

## Class Diagram
```
+--------------------------------+        +---------------------+        +--------------------------------+         +--------------------------------------+
|     Employee                   |        |    MyIterator       |        |           MyIteratorImpl       |         |           EmployeeManagement         |
+--------------------------------+        +---------------------+        +--------------------------------+         +--------------------------------------+
| - employeeId: String           |<------>| +hasNext(): boolean |<------>| - empList: List<Employee>      |         | - employeesList: ArrayList<Employee> |
| - employeeName: String         |        | +next(): Object     |        | - length: int                  |         |--------------------------------------|
| - employeeSalary: int          |        |                     |        | - position: int                |         | +addEmployee(Employee)               |
|------------------------------- |        +---------------------+        |--------------------------------|         | +getEmployee(int): Employee          |
| +Employee(String, String, int) |                                       | +MyIteratorImpl(List<Employee>)|         | +getIterator(): MyIterator           |
| +getEmployeeId(): String       |                                       | +hasNext(): boolean            |         +--------------------------------------+
| +setEmployeeId(String): void   |                                       | +next(): Object                |       
| +getEmployeeName(): String     |                                       +--------------------------------+
| +setEmployeeName(String): void |
| +getEmployeeSalary(): int      |
| +setEmployeeSalary(int): void  |
+--------------------------------+
```

## Explanation of the code

The code includes three main classes:
- Employee
- EmployeeManagement
- MyIteratorImpl

Additionally, there is a `Client` class to demonstrate the usage of the system.

## Employee Class

The *Employee* class represents an employee with attributes such as `employeeId`, `employeeName`, and `employeeSalary`. It includes getter and setter methods for each attribute.

## MyIterator Interface

The `MyIterator` interface defines the contract for iterator functionality with `hasNext()` and `next()` methods.

## MyIteratorImpl Class

The `MyIteratorImpl` class implements the `MyIterator` interface and provides `iterator` functionality for the `EmployeeManagement` class.

## EmployeeManagement Class

The `EmployeeManagement` class manages a list of employees and provides methods to add employees, get employees by index, and obtain an iterator for the employee list.

## Client Class

The `Client` class serves as a demonstration of the Employee Management System. It creates an instance of `EmployeeManagement`, adds employees, obtains an iterator, and iterates through the employee list.

The output of the `Client` class demonstrates the successful iteration through the employee list using the iterator.

This example provides a basic understanding of implementing an `iterator` pattern in Java for managing and iterating over a collection of objects, in this case, employees.

