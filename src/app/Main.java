package app;

import controller.JogadorController;
import controller.MasmorraController;
import model.Masmorra;
import view.MasmorraView;

public class Main {
    public static void main(String[] args) {

        MasmorraController masmorra = new MasmorraController(new MasmorraView(), new Masmorra());
        Jogo jogo = new Jogo(masmorra);

        JogadorController.lerJogadores(jogo, "src/XML/jogadores.xml");
        MasmorraController.lerMonstros(jogo, "src/XML/monstros.xml");
        MasmorraController.lerTesouros(jogo, "src/XML/tesouros.xml");

        jogo.iniciarJogo();

    }
}
