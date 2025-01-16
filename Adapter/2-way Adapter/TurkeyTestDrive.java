
interface Turkey{
    void gobble();
    void fly();
}

class WildTurkey implements Turkey{
    public void gobble(){
        System.out.println("Gobble! Wild Turkey");
    }
    public void fly(){
        System.out.println("Wild Turkey is flying!");
    }
}

class DuckToTurkeyAdapter implements Turkey{
    private Duck duck; 

    public DuckToTurkeyAdapter(Duck duck){
        this.duck = duck;
    }

    public void gobble(){
        duck.quack();
    }

    public void fly(){
        duck.fly();
    }   
}

public class TurkeyTestDrive {
    public static void main(String [] args){
        Turkey ref;
        ref = new WildTurkey();
        ref.gobble();
        ref.fly();

        ref = new DuckToTurkeyAdapter(new MallardDuck());
        ref.gobble();
        ref.fly();
    }
}
