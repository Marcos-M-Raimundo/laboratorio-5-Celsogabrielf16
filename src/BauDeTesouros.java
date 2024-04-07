import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BauDeTesouros extends Inventario {
    public BauDeTesouros (int limiteDeItens) {
        super(limiteDeItens);
    }

    @Override
    public Item acessarItem(String nomeItem) {
        Item item = null;

        for (Item itemInventario : this.inventario) {
            if (itemInventario.getNome().equals(nomeItem)) {
                item = itemInventario;
            }
        }

        this.removerItem(item.getNome());
        return item;
    }

    @Override
    public void listarItens() {
        Random random = new Random();
        int tamanhoAtualInventario = this.inventario.size();

        int indiceAleatorio1 = random.nextInt(tamanhoAtualInventario);
        int indiceAleatorio2 = random.nextInt(tamanhoAtualInventario);

        if (indiceAleatorio1 == indiceAleatorio2) {
            indiceAleatorio2 = (indiceAleatorio1 + 1) % (tamanhoAtualInventario);
        }
        
        System.out.println(this.inventario.get(indiceAleatorio1));
        System.out.println(this.inventario.get(indiceAleatorio2));
    }

    public List<Item> pegarItensAleatorios(int quantidadeItens) {
        List<Item> listaItensAleatorios= new ArrayList<Item>(quantidadeItens);
        Random random = new Random();

        for(int i = 0; i < quantidadeItens; i++) {
            int indiceAleatorio = random.nextInt(this.inventario.size());

            listaItensAleatorios.add(this.acessarItem(this.inventario.get(indiceAleatorio).getNome()));
        }

        return listaItensAleatorios;
    }
}
