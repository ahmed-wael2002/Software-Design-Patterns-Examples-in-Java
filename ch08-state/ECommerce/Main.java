package ECommerce;

interface IState{
    public void Next(Package x);
    public void Previous(Package x);
    public void PrintState();
}

class OrderReceivedState implements IState{
    public void Next(Package x){
        x.setState(new PackingState());
    }
    public void Previous(Package x){
        System.out.println("This is the root state -- nothing before");
    }
    public void PrintState(){
        System.out.println("Order has been received");
    }
}

class PackingState implements IState{
    public void Next(Package x){
        x.setState(new ShippmentState());
    }
    public void Previous(Package x){
        x.setState(new OrderReceivedState());
    }
    public void PrintState(){
        System.out.println("Packing state ");
    }
}

class ShippmentState implements IState{
    public void Next(Package x){
        System.out.println("Package delievered -- no further states");
    }
    public void Previous(Package x){
        x.setState(new PackingState());
    }
    public void PrintState(){
        System.out.println("Shippment Fired");
    }
}

// Package or order -- Concrete class (The object you are tracking its state)
class Package {
    IState ref;
    public Package(){
        ref = new OrderReceivedState();
    }

    public void setState(IState nextState){
        ref = nextState;
    }

    public void PrintStatus(){
        ref.PrintState();
    }

    public void PrevState(){
        ref.Previous(this);
    }

    public void NextState(){
        ref.Next(this);
    }
}

public class Main {
    public static void main(String [] args){
        Package myOrder = new Package();
        myOrder.PrintStatus();

        myOrder.NextState();
        myOrder.PrintStatus();

        myOrder.NextState();
        myOrder.PrintStatus();

        myOrder.PrevState();
        myOrder.PrintStatus();

        myOrder.NextState();
        myOrder.PrintStatus();
        
        myOrder.NextState();
        myOrder.PrintStatus();

    }
}
