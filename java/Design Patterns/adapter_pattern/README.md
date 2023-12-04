## Adapter Design Pattern
The Adapter Design Pattern is a structural design pattern that allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting the interface of a class into another interface that a client expects. This pattern involves a single class called the adapter, which is responsible for joining functionalities of independent or incompatible interfaces.

### Components of the Adapter Design Pattern:

1.  **Target:**
    
    -   This is the interface that the client expects or the interface that the client uses to interact with the adapted object.
2.  **Adapter:**
    
    -   This is the class that implements the target interface and delegates the requests to an instance of the adaptee class.
3.  **Adaptee:**
    
    -   This is the class that has the functionality that needs to be adapted. It has an interface that is incompatible with the target interface.
4.  **Client:**
    
    -   This is the class that interacts with the target interface. It is unaware of the adapter and communicates directly with the target.

```
+--------------+       +--------------+
|    Target    |<------|   Adapter    |
+--------------+       +--------------+
| request()    |       | request()    |
+--------------+       +--------------+
          |
          |             +-------------------+
          +------------>|   Adaptee         |
                        +-------------------+
                        | specificRequest() |
                        +-------------------+
```

The Adapter Design Pattern is useful when you want to reuse existing classes with incompatible interfaces, or when integrating new functionalities into existing systems. It promotes code reusability and flexibility.