
interface Duck{
    void quack();
    void fly();
}

class MallardDuck implements Duck{
    public void quack(){
        System.out.println("Quack! Mallard Duck");
    }
    public void fly(){
        System.out.println("Mallard Duck is flying!");
    }
}

class TurkeyToDuckAdapter implements Duck{
    private Turkey turkey;

    TurkeyToDuckAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    public void quack(){
        turkey.gobble();
    }

    public void fly(){
        turkey.fly();
    }
}

public class DuckTestDrive {
    public static void main(String [] args){
        Duck ref;
        ref = new MallardDuck();
        ref.quack();
        ref.fly();

        ref = new TurkeyToDuckAdapter(new WildTurkey());
        ref.quack();
        ref.fly();
    }
}
