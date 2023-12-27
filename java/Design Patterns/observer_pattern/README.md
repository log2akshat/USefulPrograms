
# Observer Design Pattern

The Observer Design Pattern is a behavioral design pattern where an object, known as the `Subject`, maintains a list of its dependents, known as `Observers`, that are notified of any state changes, typically by calling one of their methods. This pattern is also known as the `Publish-Subscribe (PubSub)` pattern.

It maintains a 1-to-Many relationship and is used when the Subject changes its state, and all its dependent objects get notified.

## Components of the Observer Design Pattern:

### 1. Subject:
The `Subject` is the object that holds the state and is being observed by other objects. It provides methods to register, unregister, and notify observers.

### 2. Observer:
The `Observer` is an interface or an abstract class that defines the update method. This method is called by the subject to notify the observer of a state change.

### 3. ConcreteSubject:
The concrete subject (In our case, the `YoutubeChannel` class) is a class that extends the subject. It maintains the state and triggers the notification to registered observers when the state changes.

### 4. ConcreteObserver:
The concrete observer (In our case, the `Subscriber` class) is a class that implements the observer interface. It registers itself with a subject to receive notifications and provides an update method to handle the state changes.

## UML Diagram:

```
+------------------+      +------------------+
|     Subject      |      |     Observer     |
+------------------+      +------------------+
| registerObserver |<>--->|    update()      |
| unregisterObserver|      +------------------+
| notifyObservers()|      
+------------------+
           |
           |
+------------------+
| ConcreteSubject  |
+------------------+
|      state       |
+------------------+
           |
           |
+------------------+
| ConcreteObserver |
+------------------+
|    update()      |
+------------------+
```

The Observer Design Pattern is widely used in Java libraries and frameworks, such as the Java GUI toolkit (Swing) where components can register as observers for changes in other components.
