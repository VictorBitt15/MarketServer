package models;

import java.rmi.RemoteException;

public class Product {
    private String cnpj;
    private String name;
    private Float value;

    public Product(String cnpj, String name, Float value) throws RemoteException {
        this.cnpj = cnpj;
		this.name = name;
		this.value = value;
	}  
    public Product(String name){
        this.name = name;
    }
    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public Float getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
