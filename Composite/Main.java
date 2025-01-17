import java.util.ArrayList;
import java.util.Iterator;

/********* 
 * Contains functions used by leaf and menus 
 * -- this might be a violation of single responsiblity principle but 
 *    it achieves transparency 
 * 
 * -- Since some functions don't make sense to be implemented by a certain class
 *      we will use a default implementation 
 * 
 * -- for instance, Menu should not implement getPrice as Menu is not a leaf node
 *      thus, we use a default implementation to avoid implementing it in its class
 * 
 * *********/
abstract class MenuComponent{
    /****************** Functions implemented by Composites only *******************/
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    /****************** Functions implemented by Leafs only *******************/
    public String getName(){
        throw new UnsupportedOperationException();
    }

    public double getPrice(){
        throw new UnsupportedOperationException();
    }

    /****************** Functions implemented by all *******************/
    public void print(){
        throw new UnsupportedOperationException();
    }

    public Iterator<MenuComponent> createIterator(){
        throw new UnsupportedOperationException();
    }
}

class MenuComponentIterator implements Iterator<MenuComponent>{
    ArrayList<MenuComponent> menuComponents;
    int position = 0;

    MenuComponentIterator(ArrayList<MenuComponent> menuComponents){
        this.menuComponents = menuComponents;
    }

    @Override
    public boolean hasNext() {
        return (position < menuComponents.size());
    }

    @Override
    public MenuComponent next() {
        MenuComponent item = menuComponents.get(position);
        position++;
        return item;
    }
}

class NullMenuIterator implements Iterator<MenuComponent>{
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }
}

class MenuItem extends MenuComponent{
    private String name;
    private double price;

    MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(this.getName() + " : " + this.getPrice());
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullMenuIterator();
    }
}


class Menu extends MenuComponent{
    private String name;
    private ArrayList<MenuComponent> menuComponents;

    Menu(String name){
        this.name = name;
        menuComponents = new ArrayList<MenuComponent>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        this.menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        this.menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    @Override
    public String getName() {
        return this.name + "\n ========================================================";
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new MenuComponentIterator(this.menuComponents);
    }

    @Override
    public void print() {
        System.out.println(this.getName());
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuComponent.print();
        }     
    }

}


public class Main{
    public static void main(String [] args){
        // 3 Types of menus 
        // 1st menu: Breakfast menu
        Menu breakfastMenu = new Menu("BREAKFAST MENU");
        breakfastMenu.add(new MenuItem("fool", 1.0));
        breakfastMenu.add(new MenuItem("ta3meyya", 2.0));
        breakfastMenu.add(new MenuItem("batates", 3.0));

        // 2nd menu: Lunch menu 
        Menu lunchMenu = new Menu("LUNCH MENU");
        lunchMenu.add(new MenuItem("Steak", 100.6));
        lunchMenu.add(new MenuItem("Cordon Bleu", 250.6));
        lunchMenu.add(new MenuItem("Pizza", 50.0));

        // 3rd menu: Dinner menu
        Menu dinnerMenu = new Menu("DINNER MENU");
        dinnerMenu.add(new MenuItem("Yogurt", 1.0));
        dinnerMenu.add(new MenuItem("Cheese", 2.0));
        dinnerMenu.add(new MenuItem("Luncheon", 3.0));

        // Culmination of all menus
        Menu fullMenu = new Menu("Restaurant Menu");
        fullMenu.add(breakfastMenu);
        fullMenu.add(lunchMenu);
        fullMenu.add(dinnerMenu);

        // 1 print function rules them all
        fullMenu.print();
    }
}