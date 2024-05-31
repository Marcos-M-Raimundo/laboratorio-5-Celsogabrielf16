package app;

import controller.JogadorController;
import controller.MasmorraController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private static Scanner scanner = new Scanner(System.in);
    private List<JogadorController> jogadores;
    private MasmorraController masmorra;
    private int numeroDaRodada;
    private int indiceJogadorAtual;
    private boolean jogadorAtualFoiDerrotado;

    public Jogo(MasmorraController masmorra) {
        this.setMasmorra(masmorra);

        ArrayList<JogadorController> ListaJogadores = new ArrayList<JogadorController>(6);
        this.setJogadores(ListaJogadores);

        this.setNumeroDaRodada(1);
        this.setIndiceJogadorAtual(0);
        this.setJogadorAtualFoiDerrotado(false);
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

    // Inicia o jogo dando 5 itens para cada jogador na jogadaInicial, e posteriormente inicia o loopDeJogo
    public void iniciarJogo() {
        for (JogadorController jogador : this.getJogadores())
            this.jogadaInicial(jogador);

        this.loopDeJogo();
        
        scanner.close();
    }

    // Pega 5 itens do bauDeTesouro e coloca no inventario de cada jogador, dando a opção dele poder equipar o mesmo
    public void jogadaInicial(JogadorController jogador) {
        List<Item> tesourosGanhos = this.getMasmorra().getTesouros().pegarItensAleatorios(5);

        System.err.println("O jogador " + jogador.getNome() + " ganhou inicialmente os seguintes itens:");
        for (Item item : tesourosGanhos) {
            jogador.getInventario().adicionarItem(item);
            System.out.println("- " + item);
        }
        
        int entradaJogador;

        do {
            System.err.println("\nDeseja equipar algum item?");
            System.err.println("1 - Sim, tentar equipar todos os itens");
            System.err.println("2 - Sim, tentar equipar alguns itens");
            System.err.println("3 - Não tentar equipar nenhum item\n");

            System.out.print("Opção escolhida: ");
            entradaJogador = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if (entradaJogador == 1) {
                for (Item item : tesourosGanhos)
                    this.equipaItem(jogador, item.getNome());
            } else if (entradaJogador == 2) {
                System.out.println("Digite o nome dos itens que deseja equipar separados por virgula:");
                System.out.print("Itens escolhidos: ");
                String linhaComItensParaEquipar = scanner.nextLine();
                System.out.println();

                List<String> listaNomeItensParaEquipar = Arrays.asList(linhaComItensParaEquipar.split(", "));
                for (String nomeItem : listaNomeItensParaEquipar)
                    this.equipaItem(jogador, nomeItem);
            }
        } while (entradaJogador == 2);
    }

    // Executa o loop de jogo, assim trocando o jogador e a rodada de jogo quando necessario
    public void loopDeJogo() {
        int entradaJogador;
        JogadorController jogadorAtual;

        do {
            // Declara o jogadorAtual e atualiza os booleans JogadorAtualFoiDerrotado para iniciar a jogada
            jogadorAtual = this.getJogadores().get(this.getIndiceJogadorAtual());
            this.setJogadorAtualFoiDerrotado(false);
            
            // Executa as acoes do jogador ate ele escolher abrir a porta ou sair do jogo
            do {
                entradaJogador = this.retornaAcaoJogador(jogadorAtual, "AntesDeAbrirAPorta");
                this.executaAcaoJogador(entradaJogador, jogadorAtual, "AntesDeAbrirAPorta");
            } while (entradaJogador != 5 && entradaJogador != 0);

            // Abre a porta se o jogador nao escolheu a acao de sair do jogo
            if (entradaJogador != 0) {
                this.executaAbrirPorta(jogadorAtual);
            }

            // Se o jogador nao escolheu sair do jogo, nem foi derrotado pelo monstro, ele pode jogar novamente antes do proximo jogador
            if (entradaJogador != 0 && !this.getJogadorAtualFoiDerrotado()) {
                do {
                    entradaJogador = this.retornaAcaoJogador(jogadorAtual, "DepoisDeAbrirAPorta");
                    this.executaAcaoJogador(entradaJogador, jogadorAtual, "DepoisDeAbrirAPorta");
                } while (entradaJogador != 5 && entradaJogador != 0);
            }
        } while (entradaJogador != 0 && this.getJogadores().size() != 0 && jogadorAtual.getNivel() < 10);

        if (this.getJogadores().size() == 0) {
            System.out.println("O jogo terminou pois todos os jogadores foram derrotados!");
        } else if (jogadorAtual.getNivel() >= 10){
            System.out.println("O jogo terminou pois o jogador " + jogadorAtual.getNome() + " alcançou o nível 10 e venceu o jogo!");
        }
    }

    // Imprime as acoes que o jogador pode tomar, e retorna a acao escolhida
    private int retornaAcaoJogador(JogadorController jogadorAtual, String identificadorAcao) {

        System.out.println("Rodada " + this.getNumeroDaRodada() + " - Jogador " + jogadorAtual.getNome());
        System.out.println("O que você deseja fazer?");

        System.out.println("1 - Listar itens do inventário");
        System.out.println("2 - Equipar itens do inventário");
        System.out.println("3 - Vender itens do inventário");
        System.out.println("4 - Ver informações do jogador");
        System.out.println(identificadorAcao.equals("AntesDeAbrirAPorta") ? "5 - Passar para abrir porta" : "5 - Terminar rodada");
        System.out.println("0 - Sair do Jogo\n");

        System.out.println("-------------------");
        System.out.print("Opção escolhida: ");
        int entradaJogador = Integer.parseInt(scanner.nextLine());
        System.out.println("-------------------\n");

        return entradaJogador;
    }

    // Executa a acao escolhida pelo jogador
    private void executaAcaoJogador(int entradaJogador, JogadorController jogadorAtual, String identificadorAcao) {
        switch (entradaJogador) {
            case 1:
                jogadorAtual.getInventario().listarItens();
                System.out.println();
                break;
            case 2:
                System.out.println("Digite o nome do item que deseja equipar:");
                System.out.print("Item escolhido: ");
                String nomeItem = scanner.nextLine();
                System.out.println();
                this.equipaItem(jogadorAtual, nomeItem);
                break;
            case 3:
                if(jogadorAtual.getInventario().inventario.size() != 0) {
                    System.out.println("Digite o nome dos itens que deseja vender separados por virgula:");
                    System.out.print("Itens escolhidos: ");
                    String linhaComItensParaVender = scanner.nextLine();
                    System.out.println();
                    List<String> listaNomeItensParaVender = Arrays.asList(linhaComItensParaVender.split(", "));
                    
                    List<Item> listaItensParaVender = new ArrayList<Item>();
                    for(String nomeItemParaVender : listaNomeItensParaVender) {
                        listaItensParaVender.add(jogadorAtual.getInventario().acessarItem(nomeItemParaVender));
                    }
    
                    jogadorAtual.venderItens(listaItensParaVender);
                    System.out.println();
                } else {
                    System.out.println("O inventário está vazio! Não existem itens a serem vendidos!\n");
                }
                break;
            case 4:
                System.out.println(jogadorAtual);
                System.out.println();
                break;
            case 5:
                if (identificadorAcao.equals("DepoisDeAbrirAPorta")) {
                    this.setIndiceJogadorAtual((this.getIndiceJogadorAtual() + 1) % this.getJogadores().size());
                    this.setNumeroDaRodada(this.getIndiceJogadorAtual() == 0 ? this.getNumeroDaRodada() + 1 : this.getNumeroDaRodada());
                }
                break;
            }
    }

    // Executa a acao de abrir a porta da masmorra
    private void executaAbrirPorta(JogadorController jogadorAtual) {
        Random random = new Random();
        int escolhaAleatoria = random.nextInt(2);

        if (escolhaAleatoria == 0) {
            this.getMasmorra().abrirPortaMonstro(jogadorAtual);
        } else {
            this.getMasmorra().abrirPortaItem(jogadorAtual, scanner);
        }

        System.out.println();

        if (jogadorAtual.getNivel() == 0) {
            this.setJogadorAtualFoiDerrotado(true);
            this.removeJogador(this.getIndiceJogadorAtual());

            if (this.getJogadores().size() != 0) {
                this.setIndiceJogadorAtual((this.getIndiceJogadorAtual() + 1) % this.getJogadores().size());
                this.setNumeroDaRodada(this.getIndiceJogadorAtual() == 0 ? this.getNumeroDaRodada() + 1 : this.getNumeroDaRodada());
            }
        }
    }

    // Remove o jogador da lista de jogadores de acordo com seu indice
    private void removeJogador(int indiceJogador) {
        this.getJogadores().remove(indiceJogador);
    }

    private void equipaItem(JogadorController jogador, String nomeItem) {
        Item itemEscolhido = jogador.getInventario().acessarItem(nomeItem);
                
        switch (itemEscolhido.getTipo()) {
            case CABECA:
                jogador.equipaItemCabeca(itemEscolhido);
                break;
            case CORPO:
                jogador.equipaItemCorpo(itemEscolhido);
                break;
            case ACESSORIO:
                jogador.equipaItemAcessorio(itemEscolhido);
                break;
            case MAO:
                System.out.println("Deseja colocar o item " + nomeItem + " em qual das mãos?");
                System.out.println("1 - Mão direita");
                System.out.println("2 - Mão esquerda");
                System.out.print("Opção escolhida: ");
                int maoEscolhida = Integer.parseInt(scanner.nextLine());

                if (maoEscolhida == 1) {
                    jogador.equipaItemMaoDireita(itemEscolhido);
                } else  {
                    jogador.equipaItemMaoEsquerda(itemEscolhido);
                }
                break;
            case PE:
                jogador.equipaItemPe(itemEscolhido);
                break;
        }
    }

    // Getters e setters dos aributos
    private List<JogadorController> getJogadores() {
        return this.jogadores;
    }

    public void setJogadores(List<JogadorController> jogadores) {
        this.jogadores = jogadores;
    }
    
    public MasmorraController getMasmorra() {
        return this.masmorra;
    }

    private void setMasmorra(MasmorraController masmorra) {
        this.masmorra = masmorra;
    }

    private int getNumeroDaRodada() {
        return this.numeroDaRodada;
    }

    private void setNumeroDaRodada(int numeroDaRodada) {
        this.numeroDaRodada = numeroDaRodada;
    }

    private int getIndiceJogadorAtual() {
        return this.indiceJogadorAtual;
    }

    private void setIndiceJogadorAtual(int indiceJogadorAtual) {
        this.indiceJogadorAtual = indiceJogadorAtual;
    }

    private boolean getJogadorAtualFoiDerrotado() {
        return this.jogadorAtualFoiDerrotado;
    }

    private void setJogadorAtualFoiDerrotado(boolean jogadorAtualFoiDerrotado) {
        this.jogadorAtualFoiDerrotado = jogadorAtualFoiDerrotado;
    }
}
