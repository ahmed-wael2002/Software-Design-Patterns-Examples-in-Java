package temp;
import java.util.ArrayList;

public class ConcreteWeatherSubject implements ISubject {
    // All subjects must contain a list of observers to call their update methods
    private ArrayList<IObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    // Add a new observer to the list of observers
    public void registerObserver(IObserver observer){
        observers.add(observer);
    }
    // Remove an observer from the list of observers
    public void removeObserver(IObserver observer){
        observers.remove(observer);
    }
    // Notify all observers in the list of observers in case of an update
    public void notifyObservers(){
        for(int i=0; i<observers.size(); i++){
            IObserver observer = (IObserver)observers.get(i);
            observer.update();
        }
    }

}
