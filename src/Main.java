import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instanciação dos objetos para teste
        //Jogador jogador1 = new Jogador("Celso", 16, "Humano", "Unicamper", "Capacete de Tartaruga", "Armadura de Netherite", "Espada de Dima", "Escudo", "Bota de Ferro");
        //Jogador jogador2 = new Jogador("Gabriel Prado");

        Classe classe = new Classe("Mago");
        List<Classe> listaDeClasses = new ArrayList<>();
        listaDeClasses.add(classe);
        Item item = new Item("Armadura de Netherite", 10, 5, "itemCorpo", false, listaDeClasses);

        //Monstro monstro = new Monstro("Creeper", 1000, 10, 100);
        //Raca raca = new Raca("Pessoa pequena", "Anao", 100);
        //Inventario inventario = new Inventario(2);
        //Classe classe = new Classe("Humana", item, item, item2);

        // Impressão de alguns métodos para teste
        //System.out.println(jogador1);
        //System.out.println(jogador2);
        //System.out.println("Jogador1 posssui mão vazia? " + jogador1.possuiMaoVazia() + "\n");
        //System.out.println("Jogador2 posssui mão vazia? " + jogador2.possuiMaoVazia() + "\n");
        //System.out.println(item);
        //System.out.println(monstro);
        //System.out.println(raca);
        //System.out.println(inventario.adicionarItem(item));
        //System.out.println(inventario.adicionarItem(item2));
        //System.out.println(inventario);
        //System.out.println(inventario.acessarItem("Armadura"));
        //inventario.removerItem("Armadura");
        //System.out.println(inventario.acessarItem("Armadura"));
        //System.out.println(inventario.acessarItem("Armaduraaa"));
        //inventario.listarInventario();
        System.out.println(classe);
        System.out.println(item);
    }
}
