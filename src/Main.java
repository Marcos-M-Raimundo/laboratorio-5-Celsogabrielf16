import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        Item itemAmuletoSorte = new Item("Amuleto da Sorte", 1, 800, TipoItem.CORPO, false, listaClasse3, listaRaca3);
        Item itemMachadoViking = new Item("Machado Viking", 4, 1200, TipoItem.MAO, true, listaClasse3, listaRaca1);

        // Lista de itens
        List<Item> listaItens = new ArrayList<>();
        listaItens.add(itemEspadaFlamejante);

        // Instanciação dos inventarios e adicionando itens
        Inventario inventario1 = new Inventario(5);
        inventario1.adicionarItem(itemElmoDragao);
        inventario1.adicionarItem(itemEspadaFlamejante);
        Inventario inventario2 = new Inventario(5);
        inventario2.adicionarItem(itemMachadoViking);
        inventario2.adicionarItem(itemAmuletoSorte);

        // Criação de um bau de tesouros
        BauDeTesouros bauDeTesouros = new BauDeTesouros(5);
        bauDeTesouros.adicionarItem(itemEspadaFlamejante);
        bauDeTesouros.adicionarItem(itemElmoDragao);
        bauDeTesouros.adicionarItem(itemMachadoViking);
        bauDeTesouros.adicionarItem(itemAmuletoSorte);

        // Instanciação dos monstros
        Monstro monstroDragaoVermelho = new Monstro("Dragão Vermelho", 5, 4, 3);
        Monstro monstroEsqueletoMisterioso = new Monstro("Esqueleto Misterioso", 3, 2, 1);

        Jogador jogador1 = new Jogador("Celso", 1, Raca.HUMANO, Classe.GUERREIRO, inventario2, null, itemAmuletoSorte, itemMachadoViking, null, null);
        Jogador jogador2 = new Jogador("Gabriel", 1, Raca.ELFO, Classe.MAGO, inventario1, itemElmoDragao, null, itemEspadaFlamejante, null, null);

        List<Jogador> listaJogadores = new ArrayList<Jogador>(6);
        listaJogadores.add(jogador1);
        listaJogadores.add(jogador2);

        int entradaJogador, indiceJogadorRodada = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            Jogador jogadorDaRodada = listaJogadores.get(indiceJogadorRodada);
            System.out.println("Jogador " + (indiceJogadorRodada + 1) + ": " + jogadorDaRodada.getNome());
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
                    break;
                case 2:
                    System.out.println("Digite o nome do item que deseja equipar:");
                    String nomeItem = scanner.nextLine();
                    Item itemEscolhido = jogadorDaRodada.getInventario().acessarItem(nomeItem);
                    System.out.println();

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
                    String linhaComItensParaVender = scanner.nextLine();
                    List<String> listaNomeItensParaVender = Arrays.asList(linhaComItensParaVender.split(", "));
                    System.out.println();

                    List<Item> listaItensParaVender = new ArrayList<Item>();
                    for(String nomeItemParaVender : listaNomeItensParaVender) {
                        listaItensParaVender.add(jogadorDaRodada.getInventario().acessarItem(nomeItemParaVender));
                    }

                    jogadorDaRodada.venderItens(listaItensParaVender);
                    break;
                case 4:
                    System.out.println(jogadorDaRodada);
                    break;
                case 5:
                    break;
                }
            System.out.println();

        } while (entradaJogador != 0);
        //indiceJogadorRodada = (indiceJogadorRodada + 1) % listaJogadores.size();
        scanner.close();
    }
}
