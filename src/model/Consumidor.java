package model;

import java.util.ArrayList;
import java.util.List;

public class Consumidor {
    private String name;
    private List<Produto> lista_produtos;

    public Consumidor(){
        this.lista_produtos = new ArrayList<Produto>();
    }

    public void add_prod_lista(Produto new_produto){
        this.lista_produtos.add(new_produto);
    }
    public List<Produto> getLista_produtos() {
        return lista_produtos;
    }
    public String getName() {
        return name;
    }
}
