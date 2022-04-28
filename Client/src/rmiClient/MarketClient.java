package rmiClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.*;

public class MarketClient extends UnicastRemoteObject implements MarketClientInterface {

	protected MarketClient() throws RemoteException {
		super();

		// new MarketServerOption().start();
	}

	@Override
	public void hello(String name)
			throws RemoteException {

		System.out.println("hello to: " + name);

	}

	// private class MarketServerOption extends Thread {
	// 	public void run() {
	// 		/**
	// 		 * Teremos aqui as opções do lado do client
	// 		 * 		(1) Envio da lista de produtos
	// 		 * 		(0) Sair do sistema
	// 		 */
	// 	}
	// }
}
