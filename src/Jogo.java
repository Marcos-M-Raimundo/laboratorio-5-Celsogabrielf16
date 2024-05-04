import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private static Scanner scanner = new Scanner(System.in);
    private List<Jogador> jogadores;
    private Masmorra masmorra;
    private int numeroDaRodada;
    private int indiceJogadorDaRodada;
    private boolean jogadorDaRodadaAbriuAPorta;
    private boolean jogadorDaRodadaFoiDerrotado;

    public Jogo(List<Jogador> jogadores, Masmorra masmorra) {
        this.setJogadores(jogadores);
        this.setMasmorra(masmorra);
        this.setNumeroDaRodada(0);
        this.setIndiceJogadorDaRodada(0);
        this.setJogadorDaRodadaAbriuAPorta(false);
        this.setJogadorDaRodadaFoiDerrotado(false);
    }

    // Método padrao chamado quando imprimimos a classe Masmorra
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Jogo { ")
            .append("Jogadores: ").append(this.getJogadores())
            .append(", Masmorra: ").append(this.getMasmorra())
            .append(" }");

        return stringBuilder.toString();
    }

    public void loopDeJogo() {
        List<Jogador> listaJogadores = this.getJogadores();
        
        int entradaJogador, indiceJogadorRodada = 0, numeroDaRodada = 1;
        boolean jogadorDerrotado = false, abrirPorta = false;

        do {
            Jogador jogadorDaRodada = listaJogadores.get(indiceJogadorRodada);
            jogadorDerrotado = false;
            
            do {
                entradaJogador = retornaAcaoJogador(jogadorDaRodada, numeroDaRodada, "PrimeiraAcao");

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
                    numeroDaRodada = indiceJogadorRodada == 0 ? ++numeroDaRodada : numeroDaRodada;
                }

                abrirPorta = false;
            }

            if (entradaJogador != 0 && jogadorDerrotado != true) {
                do {
                    entradaJogador = retornaAcaoJogador(jogadorDaRodada, numeroDaRodada, "SegundaAcao");
    
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
                            numeroDaRodada = indiceJogadorRodada == 0 ? ++numeroDaRodada : numeroDaRodada;
                            break;
                    }
                } while (entradaJogador != 5 && entradaJogador != 0);
            }

        } while (entradaJogador != 0);
        
        scanner.close();
    }

    // Imprime as acoes que o jogador pode tomar, e retorna a acao escolhida
    private int retornaAcaoJogador(Jogador jogadorDaRodada, int numeroRodada, String identificadorAcao) {

        System.out.println("Rodada " + numeroRodada + " - Jogador " + jogadorDaRodada.getNome());
        System.out.println("O que você deseja fazer?");

        System.out.println("1 - Listar itens do inventário");
        System.out.println("2 - Equipar itens do inventário");
        System.out.println("3 - Vender itens do inventário");
        System.out.println("4 - Ver informações do jogador");
        System.out.println(identificadorAcao.equals("PrimeiraAcao") ? "5 - Passar para abrir porta" : "5 - Terminar rodada");
        System.out.println("0 - Sair do Jogo\n");

        System.out.println("-------------------");
        System.out.print("Opção escolhida: ");
        int entradaJogador = Integer.parseInt(scanner.nextLine());
        System.out.println("-------------------\n");

        return entradaJogador;
    } 

    private List<Jogador> getJogadores() {
        return this.jogadores;
    }

    private void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    
    private Masmorra getMasmorra() {
        return this.masmorra;
    }

    private void setMasmorra(Masmorra masmorra) {
        this.masmorra = masmorra;
    }

    private int getNumeroDaRodada() {
        return this.numeroDaRodada;
    }

    private void setNumeroDaRodada(int numeroDaRodada) {
        this.numeroDaRodada = numeroDaRodada;
    }

    private int getIndiceJogadorDaRodada() {
        return this.indiceJogadorDaRodada;
    }

    private void setIndiceJogadorDaRodada(int indiceJogadorDaRodada) {
        this.indiceJogadorDaRodada = indiceJogadorDaRodada;
    }

    private boolean getJogadorDaRodadaFoiDerrotado() {
        return this.jogadorDaRodadaFoiDerrotado;
    }

    private void setJogadorDaRodadaFoiDerrotado(boolean jogadorDaRodadaFoiDerrotado) {
        this.jogadorDaRodadaFoiDerrotado = jogadorDaRodadaFoiDerrotado;
    }

    private boolean getJogadorDaRodadaAbriuAPorta() {
        return this.jogadorDaRodadaAbriuAPorta;
    }

    private void setJogadorDaRodadaAbriuAPorta(boolean jogadorDaRodadaAbriuAPorta) {
        this.jogadorDaRodadaAbriuAPorta = jogadorDaRodadaAbriuAPorta;
    }
}
