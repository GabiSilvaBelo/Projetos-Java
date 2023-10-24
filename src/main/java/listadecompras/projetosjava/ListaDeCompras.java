package listadecompras.projetosjava;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ListaDeCompras {
    private List<Item> itens;

    public ListaDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

public void editarItem(String nomeDoItem, Item novoItem) {
    int indice = -1;

    for (int i = 0; i < itens.size(); i++) {
        Item item = itens.get(i);

        if (item.getNome().equals(nomeDoItem)) {
            indice = i;
            break;
        }
    }

    if (indice != -1) {
        itens.set(indice, novoItem);
        System.out.println("Item editado com sucesso.");
    } else {
        System.out.println("Item não encontrado.");
    }
}
  
  public void removerItem(String nome) {
    boolean itemEncontrado = false;

    for (int i = 0; i < itens.size(); i++) {
        Item item = itens.get(i);

        if (item.getNome().equals(nome)) {
            itens.remove(i);
            itemEncontrado = true;
            System.out.println("Item removido com sucesso.");
            break;
        }
    }

    if (!itemEncontrado) {
        System.out.println("Item não encontrado.");
    }
}

    public List<Item> getItens() {
        return this.itens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeCompras lista = new ListaDeCompras();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Editar Item");
            System.out.println("3. Remover Item");
            System.out.println("4. Mostrar Lista");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine(); 
              continue; 
} 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    Item novoItem = new Item(nome, quantidade);
                    lista.adicionarItem(novoItem);
                    break;

                case 2:
                    System.out.print("Nome do item que deseja editar: ");
                    String nomeDoItem = scanner.nextLine();
                    System.out.print("Novo nome do item: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine(); 
                    break;

                case 3:
                    System.out.print("Nome do item que deseja remover: ");
                    String nomeParaRemover = scanner.nextLine();
                    lista.removerItem(nomeParaRemover);
                    break;

                case 4:
                    System.out.println("\nLista de Compras:");
                    List<Item> itens = lista.getItens();
                    for (int i = 0; i < itens.size(); i++) {
                        System.out.println(i + ". " + itens.get(i));
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}