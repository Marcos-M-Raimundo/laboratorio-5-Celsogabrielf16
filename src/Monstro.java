import java.util.List;

public class Monstro {
    private final String nome;
    private int poder;
    private List<Item> tesouros;
    private int niveisPerdidos;

    // Construtor que recebe todos os atributos do monstro
    public Monstro(String nome, int poder, List<Item> tesouros, int niveisPerdidos) {
        this.nome = nome;
        this.poder = poder;
        this.tesouros = tesouros;
        this.niveisPerdidos = niveisPerdidos;
    }

    // Método padrao chamado quando imprimimos a classe Monstro
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Monstro { ")
            .append("Nome do monstro: ").append(this.nome)
            .append(", Poder do monstro: ").append(this.poder)
            .append(", Tesouros: ").append(this.tesouros)
            .append(", Niveis Perdidos: ").append(this.niveisPerdidos)
            .append(" }");
        return stringBuilder.toString();
    }

    // Getters para cada atributo do monstro
    public String getNome() {
        return this.nome;
    }

    public int getPoder() {
        return this.poder;
    }

    public List<Item> getTesouros() {
        return this.tesouros;
    }

    public int getNiveisPerdidos() {
        return this.niveisPerdidos;
    }
}
