import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Masmorra {
    private List<Monstro> monstros;
    private BauDeTesouros tesouros;

    public Masmorra(List<Monstro> monstros, BauDeTesouros tesouros) {
        this.monstros = monstros;
        this.tesouros = tesouros;
    }

    // Método padrao chamado quando imprimimos a classe Masmorra
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Masmorra { ")
            .append("Monstros: ").append(this.monstros)
            .append(", Tesouros: ").append(this.tesouros)
            .append(" }");
        return stringBuilder.toString();
    }

    public void abrirPortaMonstro(Jogador jogador) {
        Random random = new Random();
        int indiceMonstro = random.nextInt(this.getMonstros().size());
        Monstro montroEscolhido = this.getMonstros().get(indiceMonstro);

        Resultado resultadoBatalha = CampoDeBatalha.batalhaContraMonstro(montroEscolhido, jogador);

        switch (resultadoBatalha) {
            case VITORIA:
                List<Item> tesourosGanhos = this.getTesouros().pegarItensAleatorios(montroEscolhido.getTesouros());

                for (Item tesouro : tesourosGanhos) {
                    jogador.getInventario().adicionarItem(this.getTesouros().acessarItem(tesouro.getNome()));
                }

                System.out.println("O jogador " + jogador.getNome() + " venceu a batalha contra o monstro " + montroEscolhido.getNome() + "! E com isso ganhou os tesouros: " + tesourosGanhos);
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

    public void abrirPortaItem(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um dos itens abaixo digitando seu nome:");
        getTesouros().listarItens();
        String nomeItem = scanner.nextLine();
        jogador.getInventario().adicionarItem(this.getTesouros().acessarItem(nomeItem));

        scanner.close();
    }

    // Getters da classe Masmorra
    public List<Monstro> getMonstros() {
        return this.monstros;
    }

    public BauDeTesouros getTesouros() {
        return this.tesouros;
    }
}
