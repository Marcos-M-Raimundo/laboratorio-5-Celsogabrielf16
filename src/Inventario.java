import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventario {
    private final int limiteDeItens;
    protected List<Item> inventario;

    public Inventario(int limiteDeItens) {
        this.limiteDeItens = limiteDeItens;
        // Criamos um inventario vazio
        this.inventario = new LinkedList<>();
    }

    // Método padrao chamado quando imprimimos a classe inventario
    @Override
    public String toString() {
        if (this.inventario.isEmpty()) {
            return "O inventario está vazio!";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[ ").append("Limite inventario: ").append(this.limiteDeItens).append(", Itens Inventario: [ ");
            for (Item itemInventario : this.inventario) {
                if (this.inventario.getLast().getNome().equals(itemInventario.getNome())) {
                    stringBuilder.append(itemInventario);
                } else {
                    stringBuilder.append(itemInventario).append(", ");
                }
            }
            stringBuilder.append(" ]").append(" ]");
            return stringBuilder.toString();
        }
    }

    public boolean adicionarItem(Item item) {
        return this.inventario.size() < this.limiteDeItens ? this.inventario.add(item) : false;
    }

    public Item acessarItem(String nomeItem) {
        Item itemEncontrado = null;

        for (Item itemInventario : this.inventario) {
            if (itemInventario.getNome().equals(nomeItem)) {
                itemEncontrado = itemInventario;
            }
        }

        return itemEncontrado;
    }

    public void removerItem(String nomeItem) {
        for (Item itemInventario : this.inventario) {
            if (itemInventario.getNome().equals(nomeItem)) this.inventario.remove(itemInventario);
        }
    }

    public void removerItem(List<String> listaNomesItens) {
        for (String nomeItem : listaNomesItens) {
            Iterator<Item> iterator = this.getInventario().iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                if (item.getNome().equals(nomeItem)) iterator.remove();
            }
        }
    }

    public void listarItens() {
        if (this.inventario.isEmpty()) {
            System.out.println("O inventario está vazio!");
        } else {
            System.out.println("Listando intens do inventário:");
            for (Item itemInventario : this.inventario) {
                System.out.println("- " + itemInventario);
            }
        }
    }

    public int getLimiteDeItens() {
        return this.limiteDeItens;
    }

    public List<Item> getInventario() {
        return this.inventario;
    }
}
