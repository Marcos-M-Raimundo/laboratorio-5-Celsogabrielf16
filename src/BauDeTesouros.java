import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class BauDeTesouros extends Inventario {
    public BauDeTesouros (int limiteDeItens) {
        super(limiteDeItens);
    }

    // Sobreescreve o metodo acessarItem da classe Inventario,agora alem de acessar remove o item
    @Override
    public Item acessarItem(String nomeItem) {
        Item item = null;

        Iterator<Item> iterator = this.getInventario().iterator();
        while (iterator.hasNext()) {
            Item itemInventario = iterator.next();
            if (itemInventario.getNome().equals(nomeItem)) {
                item = itemInventario;
                iterator.remove();
            }
        }

        return item;
    }

    // Sobreescreve o metodo listarItens da classe inventario, agora listando apenas dois itens aleatorios do inventario
    @Override
    public void listarItens() {
        Random random = new Random();
        int tamanhoAtualInventario = this.inventario.size();

        int indiceAleatorio1 = random.nextInt(tamanhoAtualInventario);
        int indiceAleatorio2 = random.nextInt(tamanhoAtualInventario);

        // Se os indices aleatorios forem iguais passo o indiceAleatorio2 para o proximo item
        if (indiceAleatorio1 == indiceAleatorio2)
            indiceAleatorio2 = (indiceAleatorio1 + 1) % (tamanhoAtualInventario);
        
        System.out.println(this.inventario.get(indiceAleatorio1));

        // Se ainda assim eles foram iguais 
        if (indiceAleatorio1 != indiceAleatorio2) 
            System.out.println(this.inventario.get(indiceAleatorio2));
    }

    // Retorna a quantia desejada de itens do inventario
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
