import java.util.List;
import java.util.Random;

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
                    jogador.getInventario().adicionarItem(tesouro);
                }

                System.out.println("O jogador " + jogador.getNome() + " venceu a batalha contra o monstro " + montroEscolhido.getNome() + " e ganhou os tesouros: " + tesourosGanhos);
                break;
            case FUGA:
                System.out.println("O jogador " + jogador.getNome() + " conseguiu fugiu da batalha contra o monstro " + montroEscolhido.getNome() + "!");
                break;
            case DERROTA:
                break;
        }
    }

    public void abrirPortaItem(Jogador jogador) {
        
    }

    // Getters da classe Masmorra
    public List<Monstro> getMonstros() {
        return this.monstros;
    }

    public BauDeTesouros getTesouros() {
        return this.tesouros;
    }
}
