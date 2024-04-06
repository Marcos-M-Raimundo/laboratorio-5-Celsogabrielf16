import java.util.List;

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
}
