package model;

import controller.JogadorController;
import app.BauDeTesouros;
import app.CampoDeBatalha;
import app.Item;
import app.Jogo;
import app.Monstro;
import app.Resultado;

import java.util.List;
import java.util.Random;

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

    public static void lerMonstros(Jogo jogo, String path) {
        LerMonstros monstros = new LerMonstros();
        monstros.lerArquivo(jogo, path);
    }

    public static void lerTesouros(Jogo jogo, String path) {
        LerTesouros tesouros = new LerTesouros();
        tesouros.lerArquivo(jogo, path);
    }

    public String abrirPortaMonstro(JogadorController jogador) {
        String mensagem = "";
        Monstro montroEscolhido = this.escolherMonstroAleatoriamente();
        Resultado resultadoBatalha = CampoDeBatalha.batalhaContraMonstro(montroEscolhido, jogador);

        switch (resultadoBatalha) {
            case VITORIA:
                List<Item> tesourosGanhos = this.getTesouros().pegarItensAleatorios(montroEscolhido.getTesouros());

                mensagem = "O jogador " + jogador.getNome() + " venceu a batalha contra o monstro " + montroEscolhido.getNome() + "! E com isso ganhou os tesouros: ";

                for (int i = 0; i < tesourosGanhos.size(); i++) {
                    mensagem = mensagem + tesourosGanhos.get(i).getNome();
                    if (i + 1 != tesourosGanhos.size()) {
                        mensagem = mensagem + ", ";
                    } else {
                        mensagem = mensagem + "\n";
                    }

                    jogador.getInventario().adicionarItem(tesourosGanhos.get(i));
                }

                break;
            case FUGA:
                mensagem = "O jogador " + jogador.getNome() + " conseguiu fugir da batalha contra o monstro " + montroEscolhido.getNome() + "!\n";
                break;
            case DERROTA:
                int novoNivelJogador = jogador.getNivel() - montroEscolhido.getNiveisPerdidos();

                if (novoNivelJogador > 0) {
                    jogador.setNivel(novoNivelJogador);
                    mensagem = "O jogador " + jogador.getNome() + " foi derrotado na batalha contra o monstro " + montroEscolhido.getNome() + "! E seu novo nível é " + novoNivelJogador + "!\n";
                } else {
                    jogador.setNivel(0);
                    mensagem = "O jogador " + jogador.getNome() + " foi derrotado na batalha contra o monstro " + montroEscolhido.getNome() + "! E esta fora do jogo por ter zerado seu nível!\n";
                }
                break;
        }

        return mensagem;
    }

    public Monstro escolherMonstroAleatoriamente() {
        Random random = new Random();
        int indiceMonstro = random.nextInt(this.getMonstros().size());
        return this.getMonstros().get(indiceMonstro);
    }

    public String bauDeTesourosComUmItem(JogadorController jogador) {
        String nomeUnicoItem = this.getTesouros().getInventario().get(0).getNome();
        this.adicionaInventarioJogador(jogador, nomeUnicoItem);
        return "O item " + nomeUnicoItem + " era o único no bau de tesouros, com isso, o mesmo foi adicionado ao inventário do jogador!\n";
    }

    public void adicionaInventarioJogador(JogadorController jogador, String nomeItem) {
        jogador.getInventario().adicionarItem(this.getTesouros().acessarItem(nomeItem));
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
