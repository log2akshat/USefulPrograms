# Proxy Design Pattern

The **Proxy Design Pattern** is a structural design pattern that provides a surrogate or a placeholder for another object to control access to it. The term "proxy" itself means 'in place of,' 'representing,' or 'on behalf of,' reflecting the essence of this pattern.

## Overview

Proxies are known by various names such as surrogates, handles, and wrappers. While they share similarities in structure with Adapters and Decorators, their purpose differs. In the context of the Proxy Design Pattern, a proxy serves as an intermediary that manages access to the real object.

## Real-World Analogy

To illustrate, consider real-world examples such as a cheque or credit card. In this analogy, the cheque or credit card acts as a proxy for the funds available in a bank account. These financial instruments can be used in lieu of cash, providing a convenient means of accessing the underlying funds when needed.

## Purpose of Proxy Pattern

The primary objective of the Proxy Design Pattern is to "control and manage access to the object they are protecting." It acts as a protective layer around the real object, allowing the proxy to add functionalities such as access control, logging, or lazy loading.

## Use Cases

The Proxy Design Pattern is particularly useful in scenarios where:

- **Access Control:** When there is a need to restrict or manage access to the main object.
  
- **Logging:** For capturing and logging operations performed on the real object.

- **Lazy Loading:** When the instantiation of the real object is resource-intensive, and you want to delay it until necessary.

## Explanation of the Code

### 1. **Internet Interface:**
   - Represents the common interface for both `RealInternet` and `ProxyInternet` classes.
   - Declares the `connectTo` method.

### 2. **RealInternet Class:**
   - Implements the `Internet` interface.
   - Provides the actual implementation of the `connectTo` method.
   - Represents the real internet connection.

### 3. **ProxyInternet Class:**
   - Implements the `Internet` interface.
   - Contains an instance of `RealInternet` to proxy the real internet connection.
   - Implements the `connectTo` method, which checks if the site is banned before connecting to the real internet.

### 4. **Client Class:**
   - Contains the `main` method for testing the proxy internet connection.
   - Creates an instance of `ProxyInternet` and attempts to connect to different sites, handling exceptions when access is denied.

### 5. **ArrayList:**
   - A utility class used internally in `ProxyInternet` to maintain a list of banned sites.

## Usage Scenario

1. The `Client` creates an instance of `ProxyInternet` and attempts to connect to different sites.
2. The `ProxyInternet` checks whether the site is present in the list of banned sites.
3. If the site is not banned, it delegates the connection to the real internet (`RealInternet`).
4. If the site is banned, it throws an exception ("Access Denied").

This design allows the proxy to control access to the real internet connection and implement additional functionality (in this case, checking for banned sites) without modifying the real internet class.

