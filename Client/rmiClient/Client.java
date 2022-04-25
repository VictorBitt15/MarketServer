package rmiClient;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmiServer.ServerInterface;

public class Client {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		ServerInterface server = (ServerInterface)Naming.lookup("rmi://127.0.0.1:1099/ServerMarket");
		
		server.clientStart();
	}
}
