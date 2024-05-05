public class Main {
    public static void main(String[] args) {

        Masmorra masmorra = new Masmorra();

        Jogo jogo = new Jogo(masmorra);

        LerJogadores jogadores = new LerJogadores();
        jogadores.lerArquivo(jogo, "laboratorio-4-Celsogabrielf16/src/XML/jogadores.xml");

        LerMonstros monstros = new LerMonstros();
        monstros.lerArquivo(jogo, "laboratorio-4-Celsogabrielf16/src/XML/monstros.xml");

        LerTesouros tesouros = new LerTesouros();
        tesouros.lerArquivo(jogo, "laboratorio-4-Celsogabrielf16/src/XML/tesouros.xml");

        jogo.loopDeJogo();

    }
}
