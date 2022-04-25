import java.util.ArrayList;
import java.util.List;

public class Consumidor {
    private List<Produto> lista_produtos;

    public Consumidor(){
        this.lista_produtos = new ArrayList<Produto>();
    }

    public void add_prod_lista(Produto new_produto){
        this.lista_produtos.add(new_produto);
    }
}
