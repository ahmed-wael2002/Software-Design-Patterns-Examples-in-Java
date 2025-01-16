/* ==================================================== */
/*          Strategies - varying features (speed)       */ 
/* ==================================================== */
/*
 * Strategy Design Pattern: Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
 *      Strategy lets each algorithm vary independently from clients that use it.
 */
interface IDrive{
    public void drive();
}

class LowSpeed implements IDrive{
    public void drive(){
        System.out.println("Low speed drive");
    }
}

class MediumSpeed implements IDrive{
    public void drive(){
        System.out.println("Medium speed drive");
    }
}

class HighSpeed implements IDrive{
    public void drive(){
        System.out.println("High speed drive");
    }
}

/* ==================================================== */
/*                 Concrete Class                       */ 
/* ==================================================== */
class RacingCar{
    private IDrive driveStrategy;
    
    public void setStrategy(IDrive driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        if(driveStrategy != null)
            this.driveStrategy.drive();
    }
}

/* ==================================================== */
/*                    Main Function                     */ 
/* ==================================================== */
public class StrategyExample{
    public static void main(String args []){
        RacingCar car = new RacingCar();
        car.setStrategy(new LowSpeed());
        car.drive();
        car.setStrategy(new MediumSpeed());
        car.drive();
        car.setStrategy(new HighSpeed());
        car.drive();
    }
}