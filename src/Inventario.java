import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int limiteInventario;
    private List<Item> inventario;

    public Inventario(int limiteInventario) {
        this.limiteInventario = limiteInventario;
        this.inventario = new ArrayList<>(limiteInventario);
    }

    // Método padrao chamado quando imprimimos a classe raca
    @Override
    public String toString() {
        if (this.inventario.isEmpty()) {
            return "O inventario está vazio!";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Inventario {\n");
            for (Item itemInventario : this.inventario) {
                stringBuilder.append("\t").append(itemInventario.toString()).append(",\n");
            }
            stringBuilder.append("}\n");
            return stringBuilder.toString();
        }
    }


    public int getLimiteInventario() {
        return this.limiteInventario;
    }
}
