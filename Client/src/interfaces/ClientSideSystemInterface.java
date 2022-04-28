package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientSideSystemInterface extends Remote{
    public String serverClientHud() throws RemoteException;
}
