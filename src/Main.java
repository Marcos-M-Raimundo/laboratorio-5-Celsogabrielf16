import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de Classes
        List<Classe> listaClasseAventureiro = new ArrayList<>();
        listaClasseAventureiro.add(Classe.AVENTUREIRO);
        List<Classe> listaClasseMago = new ArrayList<>();
        listaClasseMago.add(Classe.MAGO);
        listaClasseMago.add(Classe.AVENTUREIRO);
        List<Classe> listaClasseLadrao = new ArrayList<>();
        listaClasseLadrao.add(Classe.LADRAO);
        listaClasseLadrao.add(Classe.AVENTUREIRO);
        List<Classe> listaClasseGuerreiro = new ArrayList<>();
        listaClasseGuerreiro.add(Classe.GUERREIRO);
        listaClasseGuerreiro.add(Classe.AVENTUREIRO);

        // Lista de Racas
        List<Raca> listaRacaHumano = new ArrayList<>();
        listaRacaHumano.add(Raca.HUMANO);
        List<Raca> listaRacaElfo = new ArrayList<>();
        listaRacaElfo.add(Raca.ELFO);
        List<Raca> listaRacaAnao = new ArrayList<>();
        listaRacaAnao.add(Raca.ANAO);

        // Instanciação dos itens
        Item itemEspadaFlamejante = new Item("Espada Flamejante", 3, 1200, TipoItem.MAO, true, listaClasseMago, listaRacaHumano);
        Item itemElmoDragao = new Item("Elmo do Dragao", 2, 800, TipoItem.CABECA, false, listaClasseMago, listaRacaAnao);
        Item itemAmuletoSorte = new Item("Amuleto da Sorte", 1, 400, TipoItem.CORPO, false, listaClasseLadrao, listaRacaElfo);
        Item itemMachadoViking = new Item("Machado Viking", 4, 1600, TipoItem.MAO, true, listaClasseGuerreiro, listaRacaHumano);
        Item itemCapaInvisibilidade = new Item("Capa da Invisibilidade", 2, 800, TipoItem.CORPO, false, listaClasseLadrao, listaRacaAnao);
        Item itemArmaduraPlacas = new Item("Armadura de Placas", 4, 1200, TipoItem.CORPO, true, listaClasseGuerreiro, listaRacaHumano);
        Item itemCajadoArcanista = new Item("Cajado do Arcanista", 4, 1200, TipoItem.MAO, true, listaClasseAventureiro, listaRacaHumano);
        Item itemEscudoMithril = new Item("Escudo de Mithril", 2, 600, TipoItem.MAO, false, listaClasseGuerreiro, listaRacaElfo);
        Item itemBotasVelozes = new Item("Botas Velozes", 1, 600, TipoItem.PE, false, listaClasseAventureiro, listaRacaHumano);

        // Instanciação dos inventarios e adicionando itens
        Inventario inventario1 = new Inventario(5);
        inventario1.adicionarItem(itemElmoDragao);
        inventario1.adicionarItem(itemEspadaFlamejante);
        inventario1.adicionarItem(itemCapaInvisibilidade);
        Inventario inventario2 = new Inventario(5);
        inventario2.adicionarItem(itemMachadoViking);
        inventario2.adicionarItem(itemArmaduraPlacas);
        inventario2.adicionarItem(itemBotasVelozes);

        // Criação de um bau de tesouros
        BauDeTesouros bauDeTesouros = new BauDeTesouros(5);
        bauDeTesouros.adicionarItem(itemAmuletoSorte);
        bauDeTesouros.adicionarItem(itemCajadoArcanista);
        bauDeTesouros.adicionarItem(itemEscudoMithril);

        // Instanciação dos monstros
        Monstro monstroDragaoVermelho = new Monstro("Dragão Vermelho", 3, 2, 2);
        Monstro monstroEsqueletoMisterioso = new Monstro("Esqueleto Misterioso", 2, 1, 1);

        // Lista de Monstros
        List<Monstro> monstrosMasmorra = new ArrayList<Monstro>(2);
        monstrosMasmorra.add(monstroDragaoVermelho);
        monstrosMasmorra.add(monstroEsqueletoMisterioso);

        // Instanciação da masmorra
        Masmorra masmorra = new Masmorra(monstrosMasmorra, bauDeTesouros);

        Jogo jogo = new Jogo(masmorra);

        LerJogadores jogadores = new LerJogadores();
        jogadores.lerArquivo(jogo, "laboratorio-4-Celsogabrielf16/src/XML/jogadores.xml");

        jogo.loopDeJogo();

    }
}
