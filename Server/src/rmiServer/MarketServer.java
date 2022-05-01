package rmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import interfaces.*;
import models.*;

public class MarketServer extends UnicastRemoteObject implements MarketServerInterface {
	private volatile MarketClientInterface client = new MarketClient();
	
	List<Product> clientProductList;

	List<Market> serverMarketList = new ArrayList<Market>(); 
	List<Product> serverProductList = new ArrayList<Product>(); 

	protected MarketServer() throws RemoteException {
		super();
		clientProductList = new ArrayList<Product>();

		// new MarketServerOption().start();
	}

	private MarketClientInterface getClient() {
		return client;
	}

	@Override
	public void registerClient(MarketClientInterface client) throws RemoteException {
		this.client = client;
	}

	@Override
	public void receiveProductList(List<Product> clientProductList) throws RemoteException {
			this.clientProductList = clientProductList;
			
			lowestPriceList(clientProductList, serverProductList, serverMarketList);
	}

	@Override
	public void updateMarketList(List<Market> serverMarketList) throws RemoteException {
		this.serverMarketList = serverMarketList;
	}

	@Override
	public void updateProductList(List<Product> serverProductList) throws RemoteException {
		this.serverProductList = serverProductList;
	}

	private void lowestPriceList(List<Product> clientProductList, List<Product> serverProductList, List<Market> serverMarketList) throws RemoteException {
		List<Product> lowestPriceList = new ArrayList<Product>();
		List<String> clientProductListNameFilter = new ArrayList<>();

		for (Product clientProduct: clientProductList) {
			clientProductListNameFilter.add(clientProduct.getName());
		}

		for (String clientProduct: clientProductListNameFilter) {
			List<Product> clientProductFiltered; //Lista de produtos de mesmo nome
			List<String> clientProductArrayFilter = Arrays.asList(clientProduct); //Array que servirá de filtro

			clientProductFiltered = serverProductList.stream()
				.filter(productFiltered -> clientProductArrayFilter.contains(productFiltered.getName()))
				.collect(Collectors.toList());
			
			Product lowestPriceProduct = clientProductFiltered.stream()
				.min(Comparator.comparing(Product::getValue))
				.orElseThrow(NoSuchElementException::new);

			lowestPriceList.add(lowestPriceProduct);
		}


		client.printMessage(new Message(
			"|**************************|"
		));

		client.printMessage(new Message(
			"|Lista de Produtos.        |"
		));

		for (Product lowestPriceItem: lowestPriceList) {
			client.printMessage(new Message(
				"|Produto: " + lowestPriceItem.getName() +
				" Valor: " + lowestPriceItem.getValue() + 
				" Supermercado: " + lowestPriceItem.getCnpj()
			));
		}

		client.printMessage(new Message(
			"|**************************|"
		));

		client.printMessage(new Message(
			"|Mercados consultados.     |"
		));

		for (Market serverMarket: serverMarketList) {
			client.printMessage(new Message(
				"|Supermercado: " + serverMarket.getName() +
				" Cnpj: " + serverMarket.getCnpj()
			));
		}

		client.printMessage(new Message(
			"|**************************|"
		));
	}
}
