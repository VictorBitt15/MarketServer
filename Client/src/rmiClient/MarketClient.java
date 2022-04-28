package rmiClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.*;

public class MarketClient extends UnicastRemoteObject implements MarketClientInterface {

	protected MarketClient() throws RemoteException {
		super();
	}

	@Override
	public void hello(String name)
			throws RemoteException {

		System.out.println("hello to: " + name);

	}
}
