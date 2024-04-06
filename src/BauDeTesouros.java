import java.util.Random;

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

    @Override
    public void listarItens() {
        Random random = new Random();
        int tamanhoAtualInventario = this.inventario.size();

        int numeroAleatorio1 = random.nextInt(tamanhoAtualInventario);
        int numeroAleatorio2 = random.nextInt(tamanhoAtualInventario);

        if (numeroAleatorio1 == numeroAleatorio2) {
            numeroAleatorio2 = (numeroAleatorio1 + 1) % (tamanhoAtualInventario);
        }
        
        System.out.println(this.inventario.get(numeroAleatorio1));
        System.out.println(this.inventario.get(numeroAleatorio2));
    }
}
