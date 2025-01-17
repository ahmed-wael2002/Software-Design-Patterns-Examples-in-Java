
class DinnerMenuIterator implements IIterator{
    // Dinner Menu uses real arrays
    private MenuItem[] menuItems;
    private int numberOfItems = 0;
    private int MAX_ITEMS;

    DinnerMenuIterator(MenuItem[] menuItems){
        this.menuItems = menuItems;
        MAX_ITEMS = menuItems.length;
    }

    public boolean hasNext(){
        return (numberOfItems < MAX_ITEMS && menuItems[numberOfItems] != null);
    }

    public MenuItem next(){
        MenuItem item = menuItems[numberOfItems];
        numberOfItems++;
        return item;
    }
}


class DinnerMenu implements IMenu{
    private MenuItem[] menuItems;
    private int numberOfItems = 0;
    private int maxItems;

    public DinnerMenu(){
        maxItems = 5;
        menuItems = new MenuItem[maxItems];
    }

    public void addItem(MenuItem menuItem){
        if(numberOfItems >= maxItems){
            System.out.println("Cannot add any more items");
            return;
        }
        menuItems[numberOfItems] = menuItem;
        numberOfItems++;
    }

    public int getNumberOfItems(){
        return this.numberOfItems;
    }

    public MenuItem[] getMenu(){
        return this.menuItems;
    }

    public IIterator createIterator(){
        return new DinnerMenuIterator(this.menuItems);
    }
}

public class ArrayMenuMain {
    public static void main(String [] args){
        // Initializing Dinner Menu
        DinnerMenu menu = new DinnerMenu();
        menu.addItem(new MenuItem("Chicken", 1.0));
        menu.addItem(new MenuItem("Meat", 2.0));
        menu.addItem(new MenuItem("Macaronni", 3.0));

        // Code before iterator -- Code is exposed
        MenuItem[] menuItems = menu.getMenu();
        for(int i=0; i<menu.getNumberOfItems(); i++){
            System.out.println(menuItems[i].getName());
            System.out.println(menuItems[i].getPrice());
        }

        // Code after iterator
        IIterator iterator = menu.createIterator();
        MenuItem item;
        while(iterator.hasNext()){
            item = (MenuItem)iterator.next();
            System.out.println(item.getName());
            System.out.println(item.getPrice());
        }
    }
}
