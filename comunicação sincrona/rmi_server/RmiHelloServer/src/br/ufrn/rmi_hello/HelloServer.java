package br.ufrn.rmi_hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject implements HelloServerInterface {


	protected HelloServer() throws RemoteException {
		super();
		
	}

	@Override
	public void hello(String name)
			throws RemoteException {
		
		System.out.println("hello to: "+name);
		
	}

	@Override
	public String helloWorld() throws RemoteException {
		return "hello word!";
	}

}
