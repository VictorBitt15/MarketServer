package rmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import interfaces.*;
import models.Product;

public class MarketServer extends UnicastRemoteObject implements MarketServerInterface {

	protected MarketServer() throws RemoteException {
		super();

		new MarketServerOption().start();
	}

	@Override
	public void registerClient(MarketClientInterface client) throws RemoteException {
		/**
		 *  Criar função de ver Logs do sistema
		 *  Ps: Criar uma ArrayList de Clients com dados pertinentes
		 */
	}

	@Override
	public void receiveProductList(List<Product> productList) throws RemoteException {
		// TODO Auto-generated method stub
	}

	private class MarketServerOption extends Thread {
		public void run() {
			/**
			 * Teremos aqui as opções do lado do client
			 * 		(1) Receber da lista de produtos
			 * 		(0) Sair do sistema
			 */

			for(;;) {
				System.out.println();
				System.out.println("Funcionando");
				System.out.println();

				try {
					Thread.sleep(5 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				/**
				 *  Retornar a lista...
				 */
			}
		}
	}

}
