// Original interface 
interface IHero{
    void attack();
    void move();
    void stop();
}
// Class implementing the interface correctly 
class Tank implements IHero{
    public void attack(){
        System.out.println("Tank attack");
    }
    public void move(){
        System.out.println("Tank move");
    }
    public void stop(){
        System.out.println("Tank stop");
    }
}

// Outsourced class that you did not implement 
// The functions are different and the class does not implement the interface
// you cannot use ref = new RocketLauncher(); -- you need to implement an adapter
class RocketLauncher{
    public void fire(){
        System.out.println("RocketLauncher fire");
    }
    public void open(){
        System.out.println("RocketLauncher open");
    }
    public void close(){
        System.out.println("RocketLauncher close");
    }
}

// Adapter class that implements the interface and uses the outsourced class
class RocketLauncherAdapter implements IHero{
    // Get a reference of the object to be adapted
    private RocketLauncher rocketLauncher;
    RocketLauncherAdapter(RocketLauncher rocketLauncher){
        this.rocketLauncher = rocketLauncher;
    }

    public void attack(){
        rocketLauncher.fire();
    }

    public void move(){
        rocketLauncher.open();
    }

    public void stop(){
        rocketLauncher.close();
    }
}

public class OneWayAdapter{
    private static void play(IHero hero){
        hero.attack();
        hero.move();
        hero.stop();
    }

    public static void main(String[] args){
        IHero ref;
        ref = new Tank();
        play(ref);
        ref = new RocketLauncherAdapter(new RocketLauncher());
        play(ref);
    }
}