# Proxy
## What 'Proxy' actually means
Object that stands-in for a real object. It is a surrogate or placeholder for another object to control access to it.

A Proxy is an interface or an insulating layer to practically any kind of object/service

## Definition
The proxy provides a surrogate or placeholder for another object to control access to it.

## Why
Create a representative object that controls access to another object, which may be:
- Remote $\rightarrow$ **Remote Proxy**
- Expensive to create $\rightarrow$ **Virtual Proxy**
- In need of securing $\rightarrow$ **Protective Proxy**

## Types
- **Remote**: Local proxy stands-in for a remote object, handles the complexity of communication for a local client.
- **Virtual**: Light representation of a heavy/complex object. Handles light-duty operations until a real object is ready.
- **Protective**: Protection layer for an object (blocking children from access to certain web addresses).

### RemoteMethodInvocation (RMI)
#### Diagram
![RMI](https://media.geeksforgeeks.org/wp-content/uploads/20211028122357/workingofRMI.jpg)

### Code
Local proxy:
```java
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IAdd extends Remote {
    public int add(int a, int b) throws RemoteException;
}
```

Remote object:
```java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Adder extends UnicastRemoteObject implements IAdd {
    public Adder() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
```

Server:
```java
public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("Adder", new Adder());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

Client:
```java
public class Client {
    public static void main(String[] args) {
        IAdd stub = (IAdd) Naming.lookup("rmi://localhost:5000/Adder");
        System.out.println(stub.add(34, 4));
    }
}
```

### UML
`Subject` is an interface.
![Proxy](https://upload.wikimedia.org/wikipedia/commons/6/6e/W3sDesign_Proxy_Design_Pattern_UML.jpg)

## Summary
- Provides a representative for another object
- Similar to decorator, but with a different purpose
- Decorator adds behavior, Proxy controls access