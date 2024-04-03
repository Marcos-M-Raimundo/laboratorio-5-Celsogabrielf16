import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instanciação das Classes
        Mago classeMago = new Mago("O Mago é mestre nas artes arcanas, capaz de lançar feitiços poderosos para derrotar monstros e superar desafios. Sua habilidade especial geralmente envolve o uso de cartas de \"Magia\" ou a capacidade de evitar certos tipos de armadilhas.");
        Guerreiro classeGuereiro = new Guerreiro("O Guerreiro é um mestre das armas e da luta corpo a corpo. Sua habilidade especial costuma ser um bônus adicional em combates, permitindo que ele vença monstros mais facilmente.");
        Ladrao classeLadrao = new Ladrao("O Ladrão é especialista em furtividade e trapaças. Sua habilidade especial muitas vezes envolve roubar itens de outros jogadores ou ganhar vantagens em situações de negociação.");
        Classe classeGenerica = new Classe("Aventureiro Genérico");

        // Lista de Classes
        List<Classe> listaClasse1 = new ArrayList<>();
        listaClasse1.add(classeMago);
        List<Classe> listaClasse2 = new ArrayList<>();
        listaClasse2.add(classeLadrao);
        List<Classe> listaClasse3 = new ArrayList<>();
        listaClasse3.add(classeGuereiro);

        // Instanciação das Raças
        Raca racaElfo = new Raca("Elfo", "Os Elfos são ágeis e astutos, capazes de escapar de situações perigosas com facilidade.", 5);
        Raca racaAnao = new Raca("Anão", "Os Anões são robustos e resistentes, capazes de resistir a ataques poderosos.", 5);
        Raca racaHalfling = new Raca("Halfling", "Os Halflings são sorrateiros e sortudos, muitas vezes escapando de situações difíceis por um triz.", 5);


        // Instanciação dos itens
        Item itemEspadaFlamejante = new Item("Espada Flamejante", 3, 1000, "Arma", true, listaClasse1);
        Item itemElmoDragao = new Item("Elmo do Dragão", 2, 800, "Elmo", false, listaClasse1);
        Item itemAmuletoSorte = new Item("Amuleto da Sorte", 1, 400, "Item Mágico", false, listaClasse2);
        Item itemCapaInvisibilidade = new Item("Capa da Invisibilidade", 2, 800, "Equipamento", false, listaClasse2);
        Item itemArmaduraPlacas = new Item("Armadura de Placas", 4, 1200, "Armadura", true, listaClasse3);
        Item itemMachadoViking = new Item("Machado Viking", 4, 1200, "Arma", true, listaClasse3);
        Item itemCajadoArcanista = new Item("Cajado do Arcanista", 4, 1200, "Item Mágico", true);
        Item itemEscudoMithril = new Item("Escudo de Mithril", 2, 600, "Equipamento", false);
        Item itemBotasVelozes = new Item("Botas Velozes", 1, 600, "Bota", false);

        // Lista de itens
        List<Item> listaItens1 = new ArrayList<>();
        listaItens1.add(itemEspadaFlamejante);
        listaItens1.add(itemElmoDragao);
        List<Item> listaItens2 = new ArrayList<>();
        listaItens2.add(itemBotasVelozes);
        listaItens2.add(itemArmaduraPlacas);
        List<Item> listaItens3 = new ArrayList<>();
        listaItens3.add(itemCajadoArcanista);
        listaItens3.add(itemEscudoMithril);
        List<Item> listaItens4 = new ArrayList<>();
        listaItens4.add(itemAmuletoSorte);
        listaItens4.add(itemMachadoViking);
        listaItens4.add(itemCapaInvisibilidade);

        // Instanciação dos monstros
        Monstro monstroDragaoVermelho = new Monstro("Dragão Vermelho", 10, listaItens1, 3);
        Monstro monstroEsqueletoMisterioso = new Monstro("Esqueleto Misterioso", 4, listaItens2, 2);

        // Instanciação dos inventarios e adicionando itens
        Inventario inventario1 = new Inventario(5);
        inventario1.adicionarItem(itemEspadaFlamejante);
        inventario1.adicionarItem(itemElmoDragao);
        inventario1.removerItem(itemElmoDragao.getNome());
        Inventario inventario2 = new Inventario(5);
        inventario2.adicionarItem(itemMachadoViking);
        inventario2.adicionarItem(itemCajadoArcanista);
        inventario2.adicionarItem(itemBotasVelozes);
        Inventario inventario3 = new Inventario(5);
        inventario3.adicionarItem(itemArmaduraPlacas);
        inventario3.adicionarItem(itemEscudoMithril);
        Inventario inventario4 = new Inventario(5);
        inventario4.adicionarItem(itemAmuletoSorte);
        inventario4.adicionarItem(itemCapaInvisibilidade);

        // Instancição dos jogadores
        Jogador jogador1 = new Jogador("Maria", 1, racaHalfling, classeMago, inventario1);
        Jogador jogador2 = new Jogador("Gabriel", 1, racaElfo, classeGuereiro, inventario2);
        Jogador jogador3 = new Jogador("Celso", 1, racaElfo, classeGenerica, inventario3);
        Jogador jogador4 = new Jogador("Sofia", 1, racaAnao, classeLadrao, inventario4);

        // Equipa os itens no jogador
        jogador1.getClasse().setItemMaoDireita(itemEspadaFlamejante);
        jogador1.getInventario().removerItem(itemEspadaFlamejante.getNome());
        jogador2.getClasse().setItemMaoDireita(itemMachadoViking);
        jogador2.getInventario().removerItem(itemMachadoViking.getNome());
        jogador3.getClasse().setItemMaoDireita(itemEscudoMithril);
        jogador3.getInventario().removerItem(itemEscudoMithril.getNome());
        jogador4.getClasse().setItemMaoDireita(itemCapaInvisibilidade);
        jogador4.getInventario().removerItem(itemCapaInvisibilidade.getNome());

        // Não equipa uma vez que o jogador3 não é da classe Guerreiro
        jogador3.getClasse().setItemMaoDireita(itemArmaduraPlacas);

        // Não equipa uma vez que o jogador2 já tem um item grande equipado
        jogador2.getClasse().setItemMaoDireita(itemCajadoArcanista);

        // Imprime o poder dos jogadores
        System.out.println("Poder da " + jogador1.getNome() + ": "  + jogador1.poderJogador());
        System.out.println("Poder do " + jogador2.getNome() + ": "  + jogador2.poderJogador());
        System.out.println("Poder do " + jogador3.getNome() + ": "  + jogador3.poderJogador());
        System.out.println("Poder da " + jogador4.getNome() + ": "  + jogador4.poderJogador());

        // Verifica se o jogador1 possui alguma das mãos sem item
        System.out.println("A " + jogador1.getNome() + " possui mão vazia? " + jogador1.getClasse().possuiMaoVazia());
        
        // Acessa o item do inventario do jogador2
        System.out.println(jogador2.getInventario().acessarItem(itemCajadoArcanista.getNome()));

        // Lista os itens do inventario do jogador3
        jogador2.getInventario().listarInventario();

    }
}
