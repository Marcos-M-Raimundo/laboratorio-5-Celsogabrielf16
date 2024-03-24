import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instanciação dos objetos para teste
        //Jogador jogador1 = new Jogador("Celso", 16, "Humano", "Unicamper", "Capacete de Tartaruga", "Armadura de Netherite", "Espada de Dima", "Escudo", "Bota de Ferro");
        
        Classe classe = new Classe("Mago");
        Mago mago = new Mago("Mago");
        List<Classe> listaDeClasses = new ArrayList<>();
        listaDeClasses.add(classe);
        listaDeClasses.add(mago);
        Item item = new Item("Armadura de Netherite", 10, 5, "itemCorpo", false, listaDeClasses);
        Item item1 = new Item("Armadura", 10, 5, "itemCorpo", false, listaDeClasses);
        Inventario inventario = new Inventario(2);
        inventario.adicionarItem(item);
        inventario.adicionarItem(item1);
        Raca raca = new Raca("Pessoa pequena", "Anao", 100);
        Jogador jogador2 = new Jogador("Gabriel Prado", 1, raca, mago, inventario);
        //System.out.println(jogador2);

        //List<Item> listaDeItens = new ArrayList<>();
        //listaDeItens.add(item);
        //Monstro monstro = new Monstro("Creeper", 1000, listaDeItens, 100);

        // Impressão de alguns métodos para teste
        //System.out.println(jogador1);
        //System.out.println("Jogador1 posssui mão vazia? " + jogador1.possuiMaoVazia() + "\n");
        //System.out.println("Jogador2 posssui mão vazia? " + jogador2.possuiMaoVazia() + "\n");
        //System.out.println(item);
        //System.out.println(monstro);
        //System.out.println(raca);
        //System.out.println(inventario.adicionarItem(item));
        //System.out.println(inventario.adicionarItem(item2));
        System.out.println(inventario);
        //System.out.println(inventario.acessarItem("Armadura"));
        //inventario.removerItem("Armadura");
        //System.out.println(inventario.acessarItem("Armadura"));
        //System.out.println(inventario.acessarItem("Armaduraaa"));
        //inventario.listarInventario();
        //System.out.println(classe);
        //System.out.println(item);
    }
}
