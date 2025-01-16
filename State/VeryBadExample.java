class VeryBadStateDiagram{
    int currentState = 1;
    public void pull()
    {
        if(currentState == 1){
            currentState = 2;
            System.out.println("low speed");
        }
        else if (currentState == 2){
            currentState = 3;
            System.out.println("medium speed");
        }
        else if (currentState ==3 ){
            currentState = 0;
            System.out.println("high speed");
        }
        else if (currentState == 0){
            currentState = 1;
            System.out.println("fan turned off");
        }
    }
}

public class VeryBadExample{
    public static void main(String args[]){
        VeryBadStateDiagram vb = new VeryBadStateDiagram();
        vb.pull();
        vb.pull();
        vb.pull();
        vb.pull();
    }
}