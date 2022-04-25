package rmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImple extends UnicastRemoteObject implements ServerInterface {

	protected ServerImple() throws RemoteException {
		super();
		
	}

	@Override
	public void startServer() throws RemoteException {
		System.out.println("Server Iniciou");
		
	}
	
	@Override
	public void clientStart() throws RemoteException {
		System.out.println("Cliente Iniciou");
	}

}
