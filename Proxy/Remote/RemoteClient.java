import java.rmi.Naming;

class AdderProxy implements IRemote{
    
    @Override
    public int add(int a, int b){
        try{
            IRemote remoteAdder = (IRemote) Naming.lookup("rmi://localhost:5555/add");
            return remoteAdder.add(a, b);
        } 
        catch(Exception e){
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
