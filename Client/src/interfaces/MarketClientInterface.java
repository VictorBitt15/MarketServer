package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MarketClientInterface extends Remote{

	public void hello(String name) throws RemoteException;
	
}
