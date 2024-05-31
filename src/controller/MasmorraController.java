package controller;

import app.BauDeTesouros;
import app.Jogo;
import app.Monstro;
import model.Masmorra;
import view.MasmorraView;

import java.util.List;
import java.util.Scanner;

public class MasmorraController {
    public MasmorraView masmorraView;
    public Masmorra masmorra;

    public MasmorraController(MasmorraView masmorraView, Masmorra masmorra) {
        this.masmorraView = masmorraView;
        this.masmorra = masmorra;
    }

    // Método padrao chamado quando imprimimos a classe Masmorra
    @Override
    public String toString() {
        return this.masmorra.toString();
    }

    public static void lerMonstros(Jogo jogo, String path) {
        Masmorra.lerMonstros(jogo, path);
    }

    public static void lerTesouros(Jogo jogo, String path) {
        Masmorra.lerTesouros(jogo, path);
    }

    public void abrirPortaMonstro(JogadorController jogador) {
        this.masmorraView.exibirMensagem(this.masmorra.abrirPortaMonstro(jogador));
    }

    public void abrirPortaItem(JogadorController jogador, Scanner scanner) {
        if (this.masmorra.getTesouros().getInventario().size() == 1) {
            this.masmorraView.exibirMensagem(this.masmorra.bauDeTesourosComUmItem(jogador));
        } else {
            this.masmorraView.exibirMensagem("Escolha um dos itens abaixo digitando seu nome:\n");
            this.masmorra.getTesouros().listarItens();
            this.masmorraView.exibirMensagem("Item escolhido: ");
            String nomeItem = this.masmorraView.recebeString(scanner);
            this.masmorra.adicionaInventarioJogador(jogador, nomeItem);
        }
    }

    // Getters da classe Masmorra
    public List<Monstro> getMonstros() {
        return this.masmorra.getMonstros();
    }

    public void setMonstros(List<Monstro> monstros) {
        this.masmorra.setMonstros(monstros);
    }

    public BauDeTesouros getTesouros() {
        return this.masmorra.getTesouros();
    }

    public void setTesouros(BauDeTesouros tesouros) {
        this.masmorra.setTesouros(tesouros);
    }
}
