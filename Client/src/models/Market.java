package models;

import java.rmi.RemoteException;

public class Market {
    private String name;
    private String cnpj;

    public Market(){
        
    }

    public Market(String name, String cnpj) throws RemoteException {
		this.name = name;
        this.cnpj = cnpj;
	}

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

}
