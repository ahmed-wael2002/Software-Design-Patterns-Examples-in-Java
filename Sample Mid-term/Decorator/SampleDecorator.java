// Decorator Design Pattern: attaches additional functionality to an object dynamically. 
//    Decorators provide a flexible alternative to subclassing to extend functionality 

interface IPrice{
    public float calc_price();
}

// I made this as an abstract class to pass the aggregation variable "base"
abstract class BaseDecorator implements IPrice{
    protected IPrice base;  // Notice the aggregation variable is PROTECTED
    // I have written it like to invoke super directly
    BaseDecorator(IPrice base){
        this.base = base;
    }
}

class Tax extends BaseDecorator{
    Tax(IPrice base){
        super(base);
    }

    public float calc_price(){
        return this.base.calc_price() * 1.14f;
    }
}

class Shipping extends BaseDecorator{
    Shipping(IPrice base){
        super(base);
    }

    public float calc_price(){
        return this.base.calc_price() + 25.0f;
    }
}

class COD extends BaseDecorator{
    COD(IPrice base){
        super(base);
    }

    public float calc_price(){
        return this.base.calc_price() + 28.0f;
    }
}

class Invoice implements IPrice{
    public float calc_price(){
        return 15.0f;
    }
}

public class SampleDecorator{
    public static void main(String args[]){
        /*** Notice I have used 1 data type IPrice to rule them all ***/
        // 1- Invoice + Tax
        IPrice invoice = new Invoice();
        invoice = new Tax(invoice);
        System.out.println("Invoice + Tax: " + invoice.calc_price());

        // 2- Invoice + Tax + Shipping + COD
        invoice = new Invoice();
        invoice = new Tax(invoice);
        invoice = new Shipping(invoice);
        invoice = new COD(invoice);
        System.out.println("Invoice + Tax + Shipping + COD: " + invoice.calc_price());
    }
}
