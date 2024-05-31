package app;

import controller.JogadorController;
import model.LerMonstros;
import model.LerTesouros;
import model.Masmorra;

public class Main {
    public static void main(String[] args) {

        Masmorra masmorra = new Masmorra();

        Jogo jogo = new Jogo(masmorra);

        JogadorController.lerJogadores(jogo, "laboratorio-4-Celsogabrielf16/src/XML/jogadores.xml");

        LerMonstros monstros = new LerMonstros();
        monstros.lerArquivo(jogo, "laboratorio-4-Celsogabrielf16/src/XML/monstros.xml");

        LerTesouros tesouros = new LerTesouros();
        tesouros.lerArquivo(jogo, "laboratorio-4-Celsogabrielf16/src/XML/tesouros.xml");

        jogo.iniciarJogo();

    }
}
