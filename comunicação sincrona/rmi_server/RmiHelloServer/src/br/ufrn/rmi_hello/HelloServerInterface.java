package br.ufrn.rmi_hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloServerInterface extends Remote{

	public void hello(String name) throws RemoteException;
	
	public String helloWorld() throws RemoteException;
	
	public void hud() throws RemoteException;

}
