package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import models.Product;

public interface MarketServerInterface extends Remote{

	public void registerClient(MarketClientInterface client) throws RemoteException;
	public void receiveProductList(List<Product> productList) throws RemoteException;
}
