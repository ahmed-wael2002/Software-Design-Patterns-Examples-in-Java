import java.util.ArrayList;

class PancakesMenuIterator implements IIterator{
    ArrayList<MenuItem> menuItems;
    int position = 0;

    PancakesMenuIterator(ArrayList<MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return (position < menuItems.size());
    }

    @Override
    public Object next() {
        MenuItem item = menuItems.get(position);
        position++;
        return item;
    }
}


class PancakesMenu implements IMenu{
    ArrayList<MenuItem> items;
    
    PancakesMenu(){
        items = new ArrayList<MenuItem>();
    }

    public void addNewItem(String itemName, double price){
        MenuItem menuItem = new MenuItem(itemName, price);
        items.add(menuItem);
    }

    ArrayList<MenuItem> getMenu(){
        return items;
    }

    public IIterator createIterator(){
        return new PancakesMenuIterator(this.items);
    }
}

public class ArrayListMenuMain {
    static void printUsingIterator(IIterator iterator){
        MenuItem item;
        while(iterator.hasNext()){
            item = (MenuItem)iterator.next();
            System.out.println(item.getName() + " : " + item.getPrice());
        }
    }
    
    public static void main(String [] args){
        // Now we check that a single Iterator is used for both classes
        DinnerMenu dinnerMenu = new DinnerMenu();
        dinnerMenu.addItem(new MenuItem("Chicken", 1.0));
        dinnerMenu.addItem(new MenuItem("Meat", 2.0));
        dinnerMenu.addItem(new MenuItem("Bread", 3.0));

        PancakesMenu pancakesMenu = new PancakesMenu();
        pancakesMenu.addNewItem("Cinnamon Pancakes", 1.0);
        pancakesMenu.addNewItem("Mapple Syrup Pancakes", 2.0);
        pancakesMenu.addNewItem("Plain Pancakes", 3.0);

        /* You can now see that both menus are implemented quite differently */

        // We want to print the whole menu sequentially
        IIterator iterator;
        
        // Printing the dinnerMenu
        iterator = dinnerMenu.createIterator();
        printUsingIterator(iterator);

        // Printing the pancakes menu
        iterator = pancakesMenu.createIterator();
        printUsingIterator(iterator);
    }
}
