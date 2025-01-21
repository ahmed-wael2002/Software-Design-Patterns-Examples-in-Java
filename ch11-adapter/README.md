# Adapter DP
Adapts interface of class into another interface the clients expect

## Definition
Converts the interface of a class into another interface the clients expect. Lets classes work together that couldn't otherwise because of incompatible interfaces.

## Participants
- **Client**: Collaborates with objects conforming to the target interface.
- **Target**: Defines the domain-specific interface that the client uses.
- **Adaptee**: Defines an existing interface that needs adapting.
- **Adapter**: Adapts the Adaptee to the Target interface.

## UML
![Adapter](https://upload.wikimedia.org/wikipedia/commons/d/d7/ObjectAdapter.png)


## Class Adapter
- Uses multiple inheritance to adapt one interface to another.


## Summary
- Wrap an object having an incompatible interface with an adapter object that implements the desired interface
- Seen in Java in:
  - Wrapper classes (e.g. `Integer`, `Double`, `Character`)
  - `java.io.InputStreamReader` and `java.io.OutputStreamWriter`