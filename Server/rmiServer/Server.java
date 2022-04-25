package rmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;



public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException{
		System.setProperty("java.rmi.server.hostname","127.0.0.1");
		
		ServerInterface server = new ServerImple();

		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("rmi://127.0.0.1:1099/ServerMarket", server);
		
		System.out.println("Server Starterd.");

	}

}
