/** Observer Example -- Weather data **/
/*
 * Observer Design Pattern: defines one-to-many relationships between objects where
 *    if one object changes its state, the other objects are notified and updated automatically
 */
import java.util.ArrayList;

/*===================================================================== */
/*                           Display Observer                           */
/*===================================================================== */
interface IObserver{
    public void update(float temperature, float pressure, float humidity);
}

interface IDisplay{
    public void display();
}

class DisplayObserver implements IObserver,IDisplay{
    private float temperature;
    private float pressure;
    private float humidity;

    DisplayObserver(ISubject subject){
        subject.registerObserver((IObserver)this);
    }

    public void update(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("Temperature: "+this.temperature + ", Pressure: "+this.pressure + ", Humidity: " + this.humidity);
    }
}

/*===================================================================== */
/*                           Weather Subject                            */
/*===================================================================== */
interface ISubject{
    public void registerObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifyObservers();
}

class WeatherSubject implements ISubject{
    private float temperature;
    private float pressure;
    private float humidity;
    private ArrayList<IObserver> observers;

    public void registerObserver(IObserver observer){
        if(observers == null){
            observers = new ArrayList<IObserver>();
        }
        observers.add(observer);
    }

    public void removeObserver(IObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        IObserver observer;
        for(int i=0; i<observers.size(); i++){
            observer = (IObserver)observers.get(i);
            observer.update(this.temperature, this.pressure, this.humidity);
        }
    }

    public void changeMeasurements(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }
}

/*===================================================================== */
/*                           Weather Subject                            */
/*===================================================================== */
public class ObserverExample {
    public static void main (String args []){
        WeatherSubject weatherData = new WeatherSubject();
        DisplayObserver mainDisplay = new DisplayObserver(weatherData);
        mainDisplay.display();
        weatherData.changeMeasurements(23.0f, 11.2f, 13.4f);
        weatherData.changeMeasurements(32.0f, 113.22f, 13.4f);
        weatherData.changeMeasurements(23.5f, 171.2f, 132.4f);
    }
}