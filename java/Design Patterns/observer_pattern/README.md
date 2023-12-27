
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

## Class Diagram
```
+-------------------+        +------------------+
|     Subject       |        |     Observer     |
|-------------------|<>------|------------------|
| +subscribe(ob)    |        | +getNotified()   |
| +unsubscribe(ob)  |        +------------------+
| +notifyObserver() |
+-------------------+
         |
         | implements
         |
         v
+-------------------+
|  YoutubeChannel   |
|-------------------|
| +subscriberList   |
|-------------------|
| +subscribe(ob)    |
| +unsubscribe(ob)  |
| +notifyObserver() |
| +subscriberNames()|
+-------------------+
         |
         | implements
         |
         v
+-------------------+
|    Subscriber     |
|-------------------|
| -subscriberName   |
|-------------------|
| +getNotified()    |
| +getName()        |
+-------------------+
         |
         | extends
         |
         v
+-------------------+
|       Demo        |
|-------------------|
| +main()           |
| +readLine(br)     |
+-------------------+
```

In this diagram:
- `Subject` and `Observer` are interfaces representing the subject and observer roles in the Observer pattern.
- `Subject` has a one-to-many relationship with `Observer` `(1..*)`.
- `YoutubeChannel` is a concrete class implementing the `Subject` interface and maintains a list of subscribers `subscriberList`.
- `Subscriber` is a concrete class implementing the `Observer` interface and has a `subscriberName`.
- `Demo` class contains the `main` method and auxiliary methods for reading input.


## Explanation of the code
In this example, the Observer pattern is implemented for a simplified YouTube channel subscription system.

#### Components:

#### 1. Subject Interface (`Subject`)

The `Subject` interface declares the methods to manage subscribers:
- `subscribe(Observer ob)`: Adds an observer to the list.
- `unsubscribe(Observer ob)`: Removes an observer from the list.
- `notifyObserver(String title)`: Notifies all observers with the updated title.

#### 2. Observer Interface (`Observer`)

The `Observer` interface declares the method to get notified:
- `getNotified(String title)`: Receives notifications with the updated video title.

#### 3. Concrete Subject (`YoutubeChannel`)

The `YoutubeChannel` class implements the `Subject` interface and maintains a list of subscribers (`subscriberList`). It includes methods to:
- `subscribe(Observer ob)`: Adds a new observer to the list.
- `unsubscribe(Observer ob)`: Removes an observer from the list based on the subscriber's name.
- `notifyObserver(String title)`: Notifies all subscribers with the updated video title.
- `subscriberNames()`: Returns a list of subscriber names.

#### 4. Concrete Observer (`Subscriber`)

The `Subscriber` class implements the `Observer` interface and has a method:
- `getNotified(String title)`: Prints a notification when a new video is uploaded.

#### 5. Demo Class (`Demo`)

The `Demo` class demonstrates the usage of the Observer pattern:
- Creates a `YoutubeChannel` as the subject.
- Subscribes two observers (`Akshat` and `Diwakar`) to the channel.
- Notifies subscribers about a new video ("Introduction to Spring Boot").
- Prints the list of subscribers.
- Provides a menu-driven interface for user interaction, allowing video uploads, subscriber creation, and subscriber unsubscription.

The `Demo` class showcases the flexibility of the Observer pattern by allowing dynamic addition and removal of observers, enabling a scalable and decoupled system.

This example demonstrates the power of the Observer pattern in building systems where multiple objects need to react to changes in ano

