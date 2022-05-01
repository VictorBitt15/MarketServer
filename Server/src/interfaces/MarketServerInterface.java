package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import models.*;

public interface MarketServerInterface extends Remote{

	public void registerClient(MarketClientInterface client) throws RemoteException;
	public void receiveProductList(List<Product> productList) throws RemoteException;
	public void updateMarketList(List<Market> serverMarketList) throws RemoteException;
	public void updateProductList(List<Product> serverProductList) throws RemoteException;
	
}
