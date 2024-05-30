package app;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventario {
    private int limiteDeItens;
    protected List<Item> inventario;

    public Inventario(int limiteDeItens) {
        this.setLimiteDeItens(limiteDeItens);

        List<Item> inventarioVazio = new LinkedList<Item>();
        this.setInventario(inventarioVazio);
    }

    // Método padrao chamado quando imprimimos a classe inventario
    @Override
    public String toString() {
        if (this.getInventario().isEmpty()) {
            return "O inventario está vazio!";
        } else {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("[ ")
                            .append("Limite inventario: ").append(this.getLimiteDeItens())
                            .append(", Itens Inventario: [ ");

            for (int i = 0; i < this.getInventario().size(); i++) {
                stringBuilder.append(this.getInventario().get(i).getNome());

                if (i + 1 != this.getInventario().size()) 
                    stringBuilder.append(", ");
            }

            stringBuilder.append(" ]").append(" ]");

            return stringBuilder.toString();
        }
    }

    // Adiciona um item no inventario retornando false caso o inventario esteja cheio
    public boolean adicionarItem(Item item) {
        return this.getInventario().size() < this.getLimiteDeItens() ? this.getInventario().add(item) : false;
    }

    // Acessa e retorna um item de acordo com o nome recebido
    public Item acessarItem(String nomeItem) {
        Item itemEncontrado = null;

        for (Item itemInventario : this.getInventario())
            if (itemInventario.getNome().equals(nomeItem))
                itemEncontrado = itemInventario;

        return itemEncontrado;
    }

    // Remove o item de acordo com o nome
    public void removerItem(String nomeItem) {
        Iterator<Item> iterator = this.getInventario().iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getNome().equals(nomeItem)) iterator.remove();
        }
    }

    // Sobrecarrega o método anterior, agora removendo uma lista de itens
    public void removerItem(List<String> listaNomesItens) {
        for (String nomeItem : listaNomesItens) {
            this.removerItem(nomeItem);
        }
    }

    // Lista todos os itens do inventario
    public void listarItens() {
        if (this.getInventario().isEmpty()) {
            System.out.println("O inventario está vazio!");
        } else {
            System.out.println("Itens do inventário:");
            for (Item itemInventario : this.getInventario()) {
                System.out.println("- " + itemInventario);
            }
        }
    }

    // Getters e setters da classe Inventario
    private int getLimiteDeItens() {
        return this.limiteDeItens;
    }

    private void setLimiteDeItens(int limiteDeItens) {
        this.limiteDeItens = limiteDeItens;
    }

    public List<Item> getInventario() {
        return this.inventario;
    }

    private void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }
}
