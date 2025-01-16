
abstract class HouseTemplate{
    // Algorithm starting point 
    /*** final functions cannot be overridden by the class children 
     *      that's to avoid changing the algorithm common functionality 
     * ***/
    public final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built successfully!");
    }

    public final void buildFoundation(){
        System.out.println("Built Foundations");
    }

    // Customized by children classes
    public abstract void buildPillars();
    public abstract void buildWalls();

    public final void buildWindows(){
        System.out.println("Built Windows");
    }
}

class BrickHouse extends HouseTemplate{
    @Override
    public void buildPillars(){
        System.out.println("Built Brick Pillars");
    }

    @Override
    public void buildWalls(){
        System.out.println("Built Brick Walls");
    }
}

class WoodenHouse extends HouseTemplate{
    @Override
    public void buildPillars(){
        System.out.println("Built Wooden Pillars");
    }

    @Override
    public void buildWalls(){
        System.out.println("Built Wooden Walls");
    }
}

public class TemplateMain {
    public static void main(String[] args) {
        HouseTemplate house;
        
        house = new BrickHouse();
        house.buildHouse();

        house = new WoodenHouse();
        house.buildHouse();
    }
}