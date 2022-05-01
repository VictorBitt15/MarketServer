package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import models.*;

public interface MarketClientInterface extends Remote{

	public void printMessage(Message message) throws RemoteException;
	
}
