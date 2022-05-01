package rmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.*;
import models.*;

public class MarketClient extends UnicastRemoteObject implements MarketClientInterface {

	protected MarketClient() throws RemoteException {
		super();
	}

	@Override
	public void printMessage(Message message) throws RemoteException {
		System.out.println(message);
	}

}
