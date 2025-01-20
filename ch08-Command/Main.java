// This is the TV code
class TV{
    public void turnOn(){
        System.out.println("TV is turned on");
    }
    public void turnOff(){
        System.out.println("TV is turned off");
    }
}

// This is the LightBulb code
class LightBulb{
    public void lightOn(){
        System.out.println("LightBulb is turned on");
    }
    public void lightOff(){
        System.out.println("LightBulb is turned off");
    }
}

// This is the AirConditioner code
class AirConditioner{
    public void switchOn(){
        System.out.println("AirConditioner is turned on");
    }
    public void switchOff(){
        System.out.println("AirConditioner is turned off");
    }
}

interface ICommand{
    void execute();
    void undo();
}

class TVOnCommand implements ICommand{
    TV tv;

    public TVOnCommand(TV tv){
        this.tv = tv;
    }

    public void execute(){
        tv.turnOn();
    }

    public void undo(){
        tv.turnOff();
    }
}

class TVOffCommand implements ICommand{
    TV tv;

    public TVOffCommand(TV tv){
        this.tv = tv;
    }

    public void execute(){
        tv.turnOff();
    }

    public void undo(){
        tv.turnOn();
    }
}

class LightBulbOnCommand implements ICommand{
    LightBulb lightBulb;

    public LightBulbOnCommand(LightBulb lightBulb){
        this.lightBulb = lightBulb;
    }

    public void execute(){
        lightBulb.lightOn();
    }

    public void undo(){
        lightBulb.lightOff();
    }
}

class LightBulbOffCommand implements ICommand{
    LightBulb lightBulb;

    public LightBulbOffCommand(LightBulb lightBulb){
        this.lightBulb = lightBulb;
    }

    public void execute(){
        lightBulb.lightOff();
    }

    public void undo(){
        lightBulb.lightOn();
    }
}

class AirConditionerOnCommand implements ICommand{
    AirConditioner airConditioner;

    public AirConditionerOnCommand(AirConditioner airConditioner){
        this.airConditioner = airConditioner;
    }

    public void execute(){
        airConditioner.switchOn();
    }

    public void undo(){
        airConditioner.switchOff();
    }
}

class AirConditionerOffCommand implements ICommand{
    AirConditioner airConditioner;

    public AirConditionerOffCommand(AirConditioner airConditioner){
        this.airConditioner = airConditioner;
    }

    public void execute(){
        airConditioner.switchOff();
    }

    public void undo(){
        airConditioner.switchOn();
    }
}

class NoCommand implements ICommand{
    public void execute(){
        System.out.println("No command");
    }

    public void undo(){
        System.out.println("No command");
    }
}

class RemoteControl{
    ICommand[] onCommands;
    ICommand[] offCommands;

    public RemoteControl(){
        onCommands = new ICommand[3];
        offCommands = new ICommand[3];

        ICommand noCommand = new NoCommand();
        for(int i = 0; i < 3; i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, ICommand onCommand, ICommand offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
    }
}

public class Main{
    public static void main(String[] args){
        // main objects are created
        TV tv = new TV();
        LightBulb lightBulb = new LightBulb();
        AirConditioner airConditioner = new AirConditioner();

        // Lightbulb commands are created
        LightBulbOnCommand lightBulbOn = new LightBulbOnCommand(lightBulb);
        LightBulbOffCommand lightBulbOff = new LightBulbOffCommand(lightBulb);

        // TV commands are created
        TVOnCommand tvOn = new TVOnCommand(tv);
        TVOffCommand tvOff = new TVOffCommand(tv);

        // AirConditioner commands are created
        AirConditionerOnCommand airConditionerOn = new AirConditionerOnCommand(airConditioner);
        AirConditionerOffCommand airConditionerOff = new AirConditionerOffCommand(airConditioner);

        // RemoteControl object is created
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, tvOn, tvOff);
        remoteControl.setCommand(1, lightBulbOn, lightBulbOff);
        remoteControl.setCommand(2, airConditionerOn, airConditionerOff);
        remoteControl.setCommand(3, airConditionerOn, airConditionerOff);

        // TV is turned on
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);

    }
}