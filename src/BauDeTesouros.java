public class BauDeTesouros extends Inventario {
    public BauDeTesouros (int limiteDeItens) {
        super(limiteDeItens);
    }

    @Override
    public Item acessarItem(String nomeItem) {
        Item itemEncontrado = null;

        for (Item itemInventario : this.inventario) {
            if (itemInventario.getNome().equals(nomeItem)) {
                itemEncontrado = itemInventario;
            }
        }

        this.removerItem(itemEncontrado.getNome());
        return itemEncontrado;
    }
}
