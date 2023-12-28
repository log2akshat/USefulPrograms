# Chain of Responsibility Design Pattern

The Chain of Responsibility is a behavioral design pattern that enables an object to pass a request along a chain of handlers. Each handler decides whether to process the request or pass it to the next handler in the chain.

## Key Concepts:

### 1. Chain of Handlers:
   - A series of handlers (objects) arranged in a chain.
   - Each handler has a specific task or responsibility.

### 2. Passing Requests:
   - When a request comes in, the first handler in the chain checks if it can handle the request.
   - If it can handle it, it processes the request, and the process stops.
   - If it cannot handle the request, it passes the request to the next handler in the chain.

### 3. Sequential Processing:
   - The request moves through the chain sequentially until a handler is found that can process it.
   - This allows for flexible and dynamic handling of requests.

### 4. Loose Coupling:
   - Promotes loose coupling between senders (clients) and receivers (handlers) as the sender doesn’t need to know which handler will process the request.

## Example:

Consider a series of log events in an application:

- The request moves through a chain of different log levels.
- Each log level checks if the event matches their corresponding log level. If they are matched, they execute it; otherwise, they pass it to the next log level.
- This provides a flexible and extensible approval process where you can add or modify log levels without affecting the client code.

#### Real World Examples
- Loggers
- ATM Machine
- Vending Machine

## Key Components:

- **Handler Interface/Abstract Class:** Defines an interface or abstract class for handling requests.
- **Concrete Handlers:** Implement the Handler interface. Each handler decides whether to handle the request or pass it to the next handler.
- **Client:** Initiates the request and starts the chain.


## Explanation of the Chain of Responsibility Design Pattern:

#### 1. `LogProcessor` (Handler Interface/Abstract Class):
- Represents the base handler class or interface.
- Defines three log levels: `DEBUG`, `INFO`, and `ERROR` as constants.
- Holds a reference to the next `LogProcessor` in the chain (`nextLoggerProcessor`).
- The constructor initializes the next logger processor in the chain.

#### 2. `DebugLogProcessor`, `InfoLogProcessor`, `ErrorLogProcessor` (Concrete Handlers):
- Concrete implementations of the `LogProcessor` representing different log levels.
- Each constructor takes the next logger processor in the chain as a parameter and calls the constructor of the superclass to set up the chain.
- Overrides the `log` method to provide specific handling for the corresponding log level. If it can handle the log, it prints a message; otherwise, it passes the log to the next processor in the chain.

#### 3. `Client` (Client Code):
- Creates a chain of log processors with specific log levels (`DebugLogProcessor` -> `InfoLogProcessor` -> `ErrorLogProcessor`).
- Calls the `log` method on the chain for different log levels (`DEBUG`, `INFO`, `ERROR`).
- The log request moves through the chain, and each handler decides whether to process the log or pass it to the next handler.

#### 4. Output (Result of Client Code):
- The output demonstrates the processing of log messages at different levels in the chain.
- For example, if an error log is requested, the `ErrorLogProcessor` handles it; otherwise, it is passed to the next processor (`InfoLogProcessor`).

## Class Diagram
```
  +-----------------------+         has-a           +-----------+
  |    LogProcessor       |<------------------------|           |
  |                       |<--------+               |  Client   |
  +-----------------------+         |               |           |
  | - nextLoggerProcessor |         | next()        +-----------+
  +-----------------------+         |
  | + log(int, String)    |---------+
  +-----------------------+
           /_\
            |
            |is-a
            |
            |
  +---------|--------------------------------------------------------+
  |                                    |                            |
  |                                    |                            |
  v                                    v                            v
+-----------------------+   +-----------------------+   +-----------------------+
|  DebugLogProcessor    |   |   InfoLogProcessor    |   |   ErrorLogProcessor   |
+-----------------------+   +-----------------------+   +-----------------------+
|                       |   |                       |   |                       |
| + log(int, String)    |   | + log(int, String)    |   | + log(int, String)    |
|                       |   |                       |   |                       |
|                       |   |                       |   |                       |
+-----------------------+   +-----------------------+   +-----------------------+
```

## Summary
The Chain of Responsibility pattern provides a way to process requests through a chain of handlers, allowing for dynamic and flexible handling of tasks without hardcoding dependencies.
