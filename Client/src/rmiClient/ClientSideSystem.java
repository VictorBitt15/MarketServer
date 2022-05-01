package rmiClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.ClientSideSystemInterface;
import interfaces.MarketServerInterface;
import models.Product;

public class ClientSideSystem extends UnicastRemoteObject implements ClientSideSystemInterface{
    private MarketServerInterface server;

    public ClientSideSystem(MarketServerInterface server) throws RemoteException {
        super();
        this.server = server;
        System.out.println("Client iniciado");
        new ClientSideOptions().start();
    }

    @Override
    public String serverClientHud() throws RemoteException{
        Scanner sc = new Scanner(System.in);
        System.out.println("|*********************************|");
        System.out.println("| (1) Adicionar produto na lista  |");
        System.out.println("| (2) Mandar lista para busca     |");
        System.out.println("| (0) Sair do Sistema             |");
        System.out.println("|*********************************|");
        System.out.print("|Operação: ");
        String operation = sc.nextLine();
        System.out.println("|*********************************|\n\n");
        return operation;
    }
    public MarketServerInterface getServer() {
        return server;
    }

    private class ClientSideOptions extends Thread{
        public void run(){
            List<Product> productList = new ArrayList<Product>();

            System.out.println("|*********************************|");
            System.out.println("|Client inicializado.             |");
            System.out.println("|*********************************|");

            Scanner sc = new Scanner(System.in);
            while(true){
                String operation;
                
                try {
                    operation = serverClientHud();
                    switch(operation){
                        case "1":
                            System.out.println("|*********************************|");
                            System.out.println("|Adicionando produto na lista     |");
                            System.out.println("|*********************************|");
                            System.out.print("| Digite o nome do Produto: ");
                            String productName = sc.nextLine();
                            System.out.println("|*********************************|\n");
                            productList.add(new Product(productName));
                            break;
                        case "2":
    
                            if(productList.isEmpty()){
                                System.out.println("|******************************************|");
                                System.out.println("|Erro: Lista de produtos vazia.            |");
                                System.out.println("|Adicione alguns produtos e tente novamente|");
                                System.out.println("|******************************************|");
                            }else{
                                try {
                                    getServer().receiveProductList(productList);
                                } catch (RemoteException e) {
                                    System.out.println("Erro ao tentar passar lista!");
                                    e.printStackTrace();
                                }
                            }
                            break;
    
                        case "0":
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                
                
            }

        }
    }
    
}
