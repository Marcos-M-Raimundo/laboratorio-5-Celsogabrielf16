import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Masmorra {
    private List<Monstro> monstros;
    private BauDeTesouros tesouros;

    public Masmorra(List<Monstro> monstros, BauDeTesouros tesouros) {
        this.setMonstros(monstros);
        this.setTesouros(tesouros);
    }

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

    public void abrirPortaMonstro(Jogador jogador) {
        Random random = new Random();
        int indiceMonstro = random.nextInt(this.getMonstros().size());
        Monstro montroEscolhido = this.getMonstros().get(indiceMonstro);

        Resultado resultadoBatalha = CampoDeBatalha.batalhaContraMonstro(montroEscolhido, jogador);

        switch (resultadoBatalha) {
            case VITORIA:
                List<Item> tesourosGanhos = this.getTesouros().pegarItensAleatorios(montroEscolhido.getTesouros());

                for (Item tesouro : tesourosGanhos) {
                    jogador.getInventario().adicionarItem(tesouro);
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
        
        if (this.getTesouros().getInventario().size() == 1) {
            String nomeUnicoItem = this.getTesouros().getInventario().get(0).getNome();
            jogador.getInventario().adicionarItem(this.getTesouros().acessarItem(nomeUnicoItem));
            System.out.println("O item " + nomeUnicoItem + " era o único no bau de tesouros, com isso o mesmo foi adicionado ao inventário do jogador!");
        } else {
            Scanner scanner = new Scanner(System.in);
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

    private void setMonstros(List<Monstro> monstros) {
        this.monstros = monstros;
    }

    public BauDeTesouros getTesouros() {
        return this.tesouros;
    }

    private void setTesouros(BauDeTesouros tesouros) {
        this.tesouros = tesouros;
    }
}
