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
		hud();
		for(;;){

		}
	}


	public static void hud(){
		System.out.println("-----Olá, Consumidor--------------------");
		System.out.println("-----Digite a opção desejada------------");
		System.out.println("-----(1) Adicionar produto na lista-----");
		System.out.println("-----(2) Pesquisa de produtos-----------");
		System.out.println("-----(3) Finalizar----------------------");
	}
}


