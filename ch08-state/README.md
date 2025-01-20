Motivated by Finite State Machines

## State Pattern

> Allows an object to alter its behavior when its internal state changes. The object will appear to change its class

### Participants
- **`Context`**: Class that can have multiple states
- **`State`**: Common interface for concrete states
- **`ConcreteState`**: Handles requests from _Context_

### UML
![State Pattern](https://upload.wikimedia.org/wikipedia/commons/e/e8/State_Design_Pattern_UML_Class_Diagram.svg)

---

### vs. Strategy Pattern
- **State**: Behavior changes according to well-defined FSM transitions
- **Strategy**: Behavior changes according to client's request

- States store a reference to the context, while strategies don't
- States can replace themselves, while strategies can't
- Strategies are passed to the context, while states are created by the context
- Strategies handle a single specific task, while states provide underlying implementation for everything the context object does

---
### Summary
- State allows object to have different behaviors
- State represents state as class, unlike procedural FSM
- Context gets its behavior by delegating to current state
- Encapsulating each state into a class localizes changes
- State Pattern results in greater number of classes