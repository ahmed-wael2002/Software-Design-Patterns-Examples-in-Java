interface IState{
    public void NextState(CeilingFan x);
}

class LowSpeedState implements IState{
    @Override
    public void NextState(CeilingFan x){
        x.setNextState(new MediumSpeedState());
        System.out.println("low speed");
    }
}

class VeryFastSpeedState implements IState {
    @Override
    public void NextState(CeilingFan x){
        x.setNextState(new OffSpeedState());
        System.out.println("very fast speed");
    }
}


class MediumSpeedState implements IState{
    @Override
    public void NextState(CeilingFan x){
        x.setNextState(new HighSpeedState());
        System.out.println("medium speed");
    }
}


class HighSpeedState implements IState{
    @Override
    public void NextState(CeilingFan x){
        x.setNextState(new VeryFastSpeedState());
        System.out.println("high speed");
    }
}

class OffSpeedState implements IState{
    @Override
    public void NextState(CeilingFan x){
        x.setNextState(new LowSpeedState());
        System.out.println("Fan is turned off");    
    }
}

// Concrete class
class CeilingFan{
    public IState refState;

    public CeilingFan(){
        refState = new LowSpeedState();
    }

    public void pull(){
        refState.NextState(this);
    }

    public void setNextState(IState nextState){
        refState = nextState;
    }
}

public class Main{
    public static void main(String[] args){
        CeilingFan x = new CeilingFan();
        x.pull();
        x.pull();
        x.pull();
        x.pull();
        x.pull();
    }
}