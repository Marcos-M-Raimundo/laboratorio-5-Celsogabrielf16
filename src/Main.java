import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

        // Instanciação dos jogadores
        Jogador jogador1 = new Jogador("Celso", 1, Raca.HUMANO, Classe.MAGO, inventario1);
        Jogador jogador2 = new Jogador("Gabriel", 1, Raca.HUMANO, Classe.GUERREIRO, inventario2);

        // Simulação do jogo (ideal seria criar uma classe Munchkin para o controle das rodadas)
        List<Jogador> listaJogadores = new ArrayList<Jogador>(6);
        listaJogadores.add(jogador1);
        listaJogadores.add(jogador2);

        int entradaJogador, indiceJogadorRodada = 0;
        boolean jogadorDerrotado = false, abrirPorta = false;
        Scanner scanner = new Scanner(System.in);
        do {
            Jogador jogadorDaRodada = listaJogadores.get(indiceJogadorRodada);
            jogadorDerrotado = false;
            
            do {
                System.out.println("Rodada do jogador: " + jogadorDaRodada.getNome());
                System.out.println("O que você deseja fazer?");
                System.out.println("1 - Listar itens do inventário");
                System.out.println("2 - Equipar itens do inventário");
                System.out.println("3 - Vender itens do inventário");
                System.out.println("4 - Ver informações do jogador");
                System.out.println("5 - Passar para abrir porta");
                System.out.println("0 - Sair do Jogo\n");

                System.out.println("-------------------");
                System.out.print("Opção escolhida: ");
                String entradaJogadoString = scanner.nextLine();
                entradaJogador = Integer.parseInt(entradaJogadoString);
                System.out.println("-------------------\n");

                switch (entradaJogador) {
                    case 1:
                        jogadorDaRodada.getInventario().listarItens();
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Digite o nome do item que deseja equipar:");
                        System.out.print("Item escolhido: ");
                        String nomeItem = scanner.nextLine();
                        System.out.println();
                        Item itemEscolhido = jogadorDaRodada.getInventario().acessarItem(nomeItem);
                        
                        switch (itemEscolhido.getTipo()) {
                            case CABECA:
                                jogadorDaRodada.setItemCabeca(itemEscolhido);
                                break;
                            case CORPO:
                                jogadorDaRodada.setItemCorpo(itemEscolhido);
                                break;
                            case MAO:
                                System.out.println("Deseja colocar o item " + nomeItem + " em qual das mãos?");
                                System.out.println("1 - Mão direita");
                                System.out.println("2 - Mão esquerda");
                                System.out.print("Opção escolhida: ");
                                int maoEscolhida = Integer.parseInt(scanner.nextLine());
                                System.out.println();

                                if (maoEscolhida == 1) {
                                    jogadorDaRodada.setItemMaoDireita(itemEscolhido);
                                } else  {
                                    jogadorDaRodada.setItemMaoEsquerda(itemEscolhido);
                                }

                                break;
                            case PE:
                                jogadorDaRodada.setItemPe(itemEscolhido);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Digite o nome dos itens que deseja vender separados por virgula:");
                        System.out.print("Itens escolhidos: ");
                        String linhaComItensParaVender = scanner.nextLine();
                        System.out.println();
                        List<String> listaNomeItensParaVender = Arrays.asList(linhaComItensParaVender.split(", "));

                        List<Item> listaItensParaVender = new ArrayList<Item>();
                        for(String nomeItemParaVender : listaNomeItensParaVender) {
                            listaItensParaVender.add(jogadorDaRodada.getInventario().acessarItem(nomeItemParaVender));
                        }

                        jogadorDaRodada.venderItens(listaItensParaVender);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println(jogadorDaRodada);
                        System.out.println();
                        break;
                    case 5:
                        abrirPorta = true;
                        break;
                }
            } while (entradaJogador != 5 && entradaJogador != 0);

            if (abrirPorta) {
                Random random = new Random();
                int escolhaAleatoria = random.nextInt(2);

                if (escolhaAleatoria == 0) {
                    masmorra.abrirPortaMonstro(jogadorDaRodada);
                } else {
                    masmorra.abrirPortaItem(jogadorDaRodada);
                }

                System.out.println();

                if (jogadorDaRodada.getNivel() == 0) {
                    jogadorDerrotado = true;
                    listaJogadores.remove(indiceJogadorRodada);
                    indiceJogadorRodada = (indiceJogadorRodada + 1) % listaJogadores.size();
                }

                abrirPorta = false;
            }

            if (entradaJogador != 0 && jogadorDerrotado != true) {
                do {
                    System.out.println("Jogador " + (indiceJogadorRodada + 1) + ": " + jogadorDaRodada.getNome());
                    System.out.println("O que você deseja fazer?");
                    System.out.println("1 - Listar itens do inventário");
                    System.out.println("2 - Equipar itens do inventário");
                    System.out.println("3 - Vender itens do inventário");
                    System.out.println("4 - Ver informações do jogador");
                    System.out.println("5 - Terminar rodada");
                    System.out.println("0 - Sair do Jogo\n");
    
                    System.out.println("-------------------");
                    System.out.print("Opção escolhida: ");
                    String entradaJogadoString = scanner.nextLine();
                    entradaJogador = Integer.parseInt(entradaJogadoString);
                    System.out.println("-------------------\n");
    
                    switch (entradaJogador) {
                        case 1:
                            jogadorDaRodada.getInventario().listarItens();
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Digite o nome do item que deseja equipar:");
                            System.out.print("Item escolhido: ");
                            String nomeItem = scanner.nextLine();
                            System.out.println();
                            Item itemEscolhido = jogadorDaRodada.getInventario().acessarItem(nomeItem);
                            
                            switch (itemEscolhido.getTipo()) {
                                case CABECA:
                                    jogadorDaRodada.setItemCabeca(itemEscolhido);
                                    break;
                                case CORPO:
                                    jogadorDaRodada.setItemCorpo(itemEscolhido);
                                    break;
                                case MAO:
                                    System.out.println("Deseja colocar o item " + nomeItem + " em qual das mãos?");
                                    System.out.println("1 - Mão direita");
                                    System.out.println("2 - Mão esquerda");
                                    System.out.print("Opção escolhida: ");
                                    int maoEscolhida = Integer.parseInt(scanner.nextLine());
                                    System.out.println();
    
                                    if (maoEscolhida == 1) {
                                        jogadorDaRodada.setItemMaoDireita(itemEscolhido);
                                    } else  {
                                        jogadorDaRodada.setItemMaoEsquerda(itemEscolhido);
                                    }
    
                                    break;
                                case PE:
                                    jogadorDaRodada.setItemPe(itemEscolhido);
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("Digite o nome dos itens que deseja vender separados por virgula:");
                            System.out.print("Itens escolhidos: ");
                            String linhaComItensParaVender = scanner.nextLine();
                            System.out.println();
                            List<String> listaNomeItensParaVender = Arrays.asList(linhaComItensParaVender.split(", "));
    
                            List<Item> listaItensParaVender = new ArrayList<Item>();
                            for(String nomeItemParaVender : listaNomeItensParaVender) {
                                listaItensParaVender.add(jogadorDaRodada.getInventario().acessarItem(nomeItemParaVender));
                            }
    
                            jogadorDaRodada.venderItens(listaItensParaVender);
                            System.out.println();
                            break;
                        case 4:
                            System.out.println(jogadorDaRodada);
                            System.out.println();
                            break;
                        case 5:
                            indiceJogadorRodada = (indiceJogadorRodada + 1) % listaJogadores.size();
                            break;
                    }
                } while (entradaJogador != 5 && entradaJogador != 0);
            }

        } while (entradaJogador != 0);
        scanner.close();
    }
}
