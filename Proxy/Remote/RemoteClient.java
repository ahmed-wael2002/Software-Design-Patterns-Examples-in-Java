import java.rmi.Naming;

class AdderProxy implements IRemote{
    // To achieve aggregation in the proxy pattern, we create an instance of the remote object
    private IRemote remoteAdder;

    AdderProxy(){
        try{
            remoteAdder = (IRemote) Naming.lookup("rmi://localhost:5555/add");
        } 
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Override
    public int add(int a, int b){
        try{
            return remoteAdder.add(a, b);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return -1;
        }
    }
}

public class RemoteClient {
    public static void main(String [] args){
        AdderProxy adder = new AdderProxy();
        System.out.println(adder.add(1, 2));
        System.out.println(adder.add(2, 4));
        System.out.println(adder.add(-5, 10));
    }
}
