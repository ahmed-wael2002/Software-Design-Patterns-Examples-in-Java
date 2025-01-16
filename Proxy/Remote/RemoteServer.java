import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class Adder extends UnicastRemoteObject implements IRemote{

    Adder() throws RemoteException{
        super();
    }

    @Override
    public int add(int a, int b){
        return a + b;
    }
}

public class RemoteServer {
    public static void main(String [] args) throws MalformedURLException, RemoteException, NotBoundException{
        try{
            Registry r = LocateRegistry.createRegistry(5555);
            r.rebind("add", new Adder());
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
