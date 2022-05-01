package rmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.*;
import models.*;


public class ServerSideSystem extends UnicastRemoteObject implements ServerSideSystemInterface {
    private MarketServerInterface server;

    public ServerSideSystem(MarketServerInterface server) throws RemoteException {	
        super();
        this.server = server;

        System.out.println("Server de mercados inicializado.");
		new ServerSideOptions().start();
	}

    @Override
    public String serverMainHud() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("|*********************************|");
        System.out.println("| (1) Registrar novo Supermercado |");
        System.out.println("| (2) Registrar novo Produto      |");
        System.out.println("| (3) Registro(s) de Supermercados|");
        System.out.println("| (4) Registro(s) de Produtos     |");
        System.out.println("| (0) Sair do Sistema             |");
        System.out.println("|*********************************|");
          System.out.print("|Operação: ");
          String operation = sc.nextLine();
        System.out.println("|*********************************|\n\n");

        return operation;
    }

    private class ServerSideOptions extends Thread {
        public void run() {
            List<Market> marketList = new ArrayList<Market>();
            List<Product> productList = new ArrayList<Product>();

            System.out.println("|*********************************|");
            System.out.println("|Server de mercados inicializado. |");
            System.out.println("|*********************************|");
            
            Scanner sc = new Scanner(System.in);
            
            while(true){
                String operation = serverMainHud();

                switch (operation) {
                    case "1":
                        Boolean marketAlreadyExists = false;

                        System.out.println("|*********************************|");
                        System.out.println("| Registrando Supermercado        |");
                        System.out.println("|*********************************|");
                          System.out.print("| Digite o nome do Supermercado: ");
                          String marketName = sc.nextLine();
                          System.out.print("| Digite o Cnpj do Supermercado: ");
                          String marketCnpj = sc.nextLine();
                        System.out.println("|*********************************|");
                          System.out.println();
                          System.out.println();
                          
                        try {
                            for (Market marketInto: marketList) {
                                if (marketCnpj.equals(marketInto.getCnpj())) {
                                    System.out.println();
                                    System.out.println("|*********************************|");
                                    System.out.println("|Erro: Supermercado já registrado.|");
                                    System.out.println("|*********************************|");
                                    System.out.println();

                                    marketAlreadyExists = true;
                                }
                            }

                            if (marketAlreadyExists) {
                                break;
                            } else {
                                Market market = new Market(marketName, marketCnpj);
                                marketList.add(market);
                                server.updateMarketList(marketList);
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }

                        break;
                    case "2":
                        Boolean marketAvailable = false;
                    
                        System.out.println("|********************************|");
                        System.out.println("| Registrando Produto            |");
                        System.out.println("|********************************|");
                          System.out.print("| Digite o cnpj do Supermercado: ");
                          String productMarketCnpj = sc.nextLine();
                          System.out.print("| Digite o nome do Produto: ");
                          String productName = sc.nextLine();
                          System.out.print("| Digite o preço do Produto (ex: 23.16): ");
                          String productValue = sc.nextLine();

                        try {
                            for (Market marketInto: marketList) {
                                if (productMarketCnpj.equals(marketInto.getCnpj())) {
                                    marketAvailable = true;
                                }
                            } 

                            if (marketAvailable) {
                                Boolean itemAvailableToRegister = true;

                                for (Product productInto: productList) {
                                    if (productName.equals(productInto.getName())){
                                        if (productMarketCnpj.equals(productInto.getCnpj())){
                                            System.out.println();
                                            System.out.println("|*********************************|");
                                            System.out.println("|Erro: Item já consta no mercado. |");
                                            System.out.println("|*********************************|");
                                            System.out.println();

                                            itemAvailableToRegister = false;
                                            break;
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                } 

                                if (itemAvailableToRegister) {
                                    Float floatproductValue = Float.parseFloat(productValue);
                                    Product product = new Product(productMarketCnpj, productName, floatproductValue);
                                    productList.add(product);
                                    server.updateProductList(productList);
                                } else {
                                    break;
                                }
                            } else {
                                System.out.println();
                                System.out.println("|*********************************|");
                                System.out.println("|Erro: Cnpj não cadastrado.       |");
                                System.out.println("|*********************************|");
                                System.out.println();
                                
                                break;
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        
                        break;
                    case "3":
                        if (marketList.size() > 0) {
                            for (Market marketInto: marketList) {
                                System.out.println("Supermercado: " + marketInto.getName() + " Cnpj: " + marketInto.getCnpj());
                            }
                        } else {
                            System.out.println();
                            System.out.println("|*********************************|");
                            System.out.println("|Não há registro de supermercados.|");
                            System.out.println("|*********************************|");
                            System.out.println();
                        }
                        break;
                    case "4":
                        if (productList.size() > 0) {
                            for (Product productInto: productList) {
                                System.out.println("\nProduto: " + productInto.getName() + " Valor: " + productInto.getValue() + " Cnpj: " + productInto.getCnpj());
                            }
                        } else {
                            System.out.println();
                            System.out.println("|*********************************|");
                            System.out.println("|Não há registro de produtos.     |");
                            System.out.println("|*********************************|");
                            System.out.println();
                        }
                        break;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
