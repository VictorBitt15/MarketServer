package models;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private String name;
    private List<Product> productList;

    public Consumer(){
        this.productList = new ArrayList<Product>();
    }

    public void addProductList(Product new_produto){
        this.productList.add(new_produto);
    }
    
    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }
}
