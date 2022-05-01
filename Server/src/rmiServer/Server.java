package rmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import interfaces.*;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		System.setProperty("java.rmi.server.hostname", "127.0.0.1");

		MarketServerInterface server = new MarketServer();

		LocateRegistry.createRegistry(1099);

		Naming.rebind("rmi://127.0.0.1:1099/MarketServer", server);

		ServerSideSystemInterface serverSideSystem = new ServerSideSystem(server);

	}

}
