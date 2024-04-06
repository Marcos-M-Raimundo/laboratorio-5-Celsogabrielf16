import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de Classes
        List<Classe> listaClasse1 = new ArrayList<>();
        listaClasse1.add(Classe.MAGO);
        listaClasse1.add(Classe.AVENTUREIRO);
        List<Classe> listaClasse2 = new ArrayList<>();
        listaClasse2.add(Classe.LADRAO);
        List<Classe> listaClasse3 = new ArrayList<>();
        listaClasse3.add(Classe.GUERREIRO);

        // Lista de Racas
        List<Raca> listaRaca1 = new ArrayList<>();
        listaRaca1.add(Raca.HUMANO);
        List<Raca> listaRaca2 = new ArrayList<>();
        listaRaca2.add(Raca.ELFO);
        List<Raca> listaRaca3 = new ArrayList<>();
        listaRaca3.add(Raca.ANAO);


        // Instanciação dos itens
        Item itemEspadaFlamejante = new Item("Espada Flamejante", 3, 1000, TipoItem.MAO, true, listaClasse1, listaRaca1);
        Item itemElmoDragao = new Item("Elmo do Dragão", 2, 800, TipoItem.CORPO, false, listaClasse2, listaRaca2);
        Item itemAmuletoSorte = new Item("Amuleto da Sorte", 1, 400, TipoItem.CORPO, false, listaClasse3, listaRaca3);
        Item itemMachadoViking = new Item("Machado Viking", 4, 1200, TipoItem.MAO, true, listaClasse3, listaRaca1);

        // Lista de itens
        List<Item> listaItens1 = new ArrayList<>();
        listaItens1.add(itemEspadaFlamejante);
        listaItens1.add(itemElmoDragao);
        List<Item> listaItens2 = new ArrayList<>();
        listaItens2.add(itemAmuletoSorte);
        listaItens2.add(itemMachadoViking);

        // Instanciação dos inventarios e adicionando itens
        Inventario inventario1 = new Inventario(5);
        inventario1.adicionarItem(itemEspadaFlamejante);
        inventario1.adicionarItem(itemElmoDragao);
        inventario1.removerItem(itemElmoDragao.getNome());
        Inventario inventario2 = new Inventario(5);
        inventario2.adicionarItem(itemMachadoViking);
        inventario2.adicionarItem(itemAmuletoSorte);

        BauDeTesouros bauDeTesouros = new BauDeTesouros(5);
        bauDeTesouros.adicionarItem(itemEspadaFlamejante);
        bauDeTesouros.adicionarItem(itemElmoDragao);
        bauDeTesouros.adicionarItem(itemMachadoViking);
        bauDeTesouros.adicionarItem(itemAmuletoSorte);

        System.out.println(bauDeTesouros);
        
        bauDeTesouros.acessarItem("Elmo do Dragão");
        
        System.out.println(bauDeTesouros);
        
        bauDeTesouros.pegarItensAleatorios(2);
        
        System.out.println(bauDeTesouros);
    }
}
