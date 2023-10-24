package listadecompras.projetosjava;

import java.util.ArrayList;
import java.util.List;

public class GerenciarLista {
    private List<Item> itens;

    public GerenciarLista() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void editarItem(int indice, Item novoItem) {
        itens.set(indice, novoItem);
    }

    public void removerItem(String nome) {
        itens.remove(nome);
    }

    public List<Item> getItens() {
        return itens;
    }
}
