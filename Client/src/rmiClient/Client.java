package rmiClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import interfaces.*;

public class Client {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		MarketServerInterface server = (MarketServerInterface)
				Naming.lookup("rmi://127.0.0.1:1099/MarketServer");
		
		MarketClientInterface client = new MarketClient();

		server.registerClient(client);
		
		ClientSideSystemInterface clientSideSystem = new ClientSideSystem(server);
	}
}


