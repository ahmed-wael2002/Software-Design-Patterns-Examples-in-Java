package temp;
public class ConcreteDisplayObserver {
    // Observer variables 
    private float temperature;
    private float humidity;
    private float pressure;
    
    ConcreteDisplayObserver(ISubject subject){
        subject.registerObserver((IObserver)this);
    }

    public void display() {
        System.out.println("Temperature: " + temperature + " Humidity: " + humidity + " Pressure: " + pressure);
    }

    public void update(float temperature, float humidity, float pressure){ 
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
