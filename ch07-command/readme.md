Idea comes from **macros** where new commands are created as sequences of existing commands.

**Encapsulate method calls** in an object **to decouple the object requesting a service** from the object providing the service.

Provides the opportunity:
- Undo actions
- Redo actions
- Queue actions

---

The Command DP is made up of:
- **Receiver**: Contains specific action methods
- **Invoker**: Holds Command objects
- **Command**: Encapsulates some operation on a Receiver
  - Has an `execute` method which calls action methods on the Receiver.
- **Client**: The requestor of actions
  - Creates a Command object
  - Calls `setCommand` on Invoker to “plug-in” the Command


---
- Decouples the invoker and the receiver by using intermediary command objects.
- Can result in many small command classes
  - Good naming convention and class factoring are important