package model;

import controller.JogadorController;
import app.BauDeTesouros;
import app.CampoDeBatalha;
import app.Item;
import app.Monstro;
import app.Resultado;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Masmorra {
    private List<Monstro> monstros;
    private BauDeTesouros tesouros;

    // Método padrao chamado quando imprimimos a classe Masmorra
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Masmorra { ")
            .append("Monstros: ").append(this.getMonstros())
            .append(", Tesouros: ").append(this.getTesouros())
            .append(" }");

        return stringBuilder.toString();
    }

    public void abrirPortaMonstro(JogadorController jogador) {
        Random random = new Random();
        int indiceMonstro = random.nextInt(this.getMonstros().size());
        Monstro montroEscolhido = this.getMonstros().get(indiceMonstro);

        Resultado resultadoBatalha = CampoDeBatalha.batalhaContraMonstro(montroEscolhido, jogador);

        switch (resultadoBatalha) {
            case VITORIA:
                List<Item> tesourosGanhos = this.getTesouros().pegarItensAleatorios(montroEscolhido.getTesouros());

                System.out.print("O jogador " + jogador.getNome() + " venceu a batalha contra o monstro " + montroEscolhido.getNome() + "! E com isso ganhou os tesouros: ");

                for (int i = 0; i < tesourosGanhos.size(); i++) {
                    System.out.print(tesourosGanhos.get(i).getNome());
                    if (i + 1 != tesourosGanhos.size()) {
                        System.out.print(", ");
                    } else {
                        System.out.println();
                    }

                    jogador.getInventario().adicionarItem(tesourosGanhos.get(i));
                }

                break;
            case FUGA:
                System.out.println("O jogador " + jogador.getNome() + " conseguiu fugiu da batalha contra o monstro " + montroEscolhido.getNome() + "!");
                break;
            case DERROTA:
                int novoNivelJogador = jogador.getNivel() - montroEscolhido.getNiveisPerdidos();

                if (novoNivelJogador > 0) {
                    jogador.setNivel(novoNivelJogador);
                    System.out.println("O jogador " + jogador.getNome() + " foi derrotado na batalha contra o monstro " + montroEscolhido.getNome() + "! E seu novo nível é " + novoNivelJogador + "!");
                } else {
                    jogador.setNivel(0);
                    System.out.println("O jogador " + jogador.getNome() + " foi derrotado na batalha contra o monstro " + montroEscolhido.getNome() + "! E esta fora do jogo por ter zerado seu nível!");
                }
                break;
        }
    }

    public void abrirPortaItem(JogadorController jogador, Scanner scanner) {
        if (this.getTesouros().getInventario().size() == 1) {
            String nomeUnicoItem = this.getTesouros().getInventario().get(0).getNome();
            jogador.getInventario().adicionarItem(this.getTesouros().acessarItem(nomeUnicoItem));
            System.out.println("O item " + nomeUnicoItem + " era o único no bau de tesouros, com isso o mesmo foi adicionado ao inventário do jogador!");
        } else {
            System.out.println("Escolha um dos itens abaixo digitando seu nome:");
            getTesouros().listarItens();
            System.out.print("Item escolhido: ");
            String nomeItem = scanner.nextLine();
            jogador.getInventario().adicionarItem(this.getTesouros().acessarItem(nomeItem));
        }
    }

    // Getters da classe Masmorra
    public List<Monstro> getMonstros() {
        return this.monstros;
    }

    public void setMonstros(List<Monstro> monstros) {
        this.monstros = monstros;
    }

    public BauDeTesouros getTesouros() {
        return this.tesouros;
    }

    public void setTesouros(BauDeTesouros tesouros) {
        this.tesouros = tesouros;
    }
}
