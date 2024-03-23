import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int limiteInventario;
    private List<Item> inventario;

    public Inventario(int limiteInventario) {
        this.limiteInventario = limiteInventario;
        inventario = new ArrayList<>(limiteInventario);
    }

    public int getLimiteInventario() {
        return this.limiteInventario;
    }
}
