import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int limiteInventario;
    private List<Item> inventario;

    public Inventario(int limiteInventario) {
        // Criamos um inventario vazio
        this.inventario = new ArrayList<>(limiteInventario);
        this.limiteInventario = limiteInventario;
    }

    // Método padrao chamado quando imprimimos a classe inventario
    @Override
    public String toString() {
        if (this.inventario.isEmpty()) {
            return "O inventario está vazio!";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Limite inventario: " + this.limiteInventario + ",\n");
            stringBuilder.append("Inventario {\n");
            for (Item itemInventario : this.inventario) {
                stringBuilder.append("\t").append(itemInventario).append(",\n");
            }
            stringBuilder.append("}\n");
            return stringBuilder.toString();
        }
    }

    public boolean adicionarItem(Item item) {
        return this.inventario.size() < this.limiteInventario ? this.inventario.add(item) : false;
    }

    public void removerItem(String nomeItem) {
        for (Item itemInventario : this.inventario) {
            if (itemInventario.getNome().equals(nomeItem)) {
                this.inventario.remove(itemInventario);
                break;
            }
        }
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

    public void listarInventario() {
        for (Item itemInventario : this.inventario) {
            System.out.println(itemInventario);
        }
    }

    public int getLimiteInventario() {
        return this.limiteInventario;
    }
}
