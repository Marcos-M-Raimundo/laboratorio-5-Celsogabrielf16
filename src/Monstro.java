import java.util.List;

public class Monstro {
    private final String nome;
    private final int poder;
    private final int tesouros;
    private final int niveisPerdidos;

    // Construtor que recebe todos os atributos do monstro
    public Monstro(String nome, int poder, int tesouros, int niveisPerdidos) {
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
            .append("Nome: ").append(this.nome)
            .append(", Poder: ").append(this.poder)
            .append(", Número de Pesouros: ").append(this.tesouros)
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

    public int getTesouros() {
        return this.tesouros;
    }

    public int getNiveisPerdidos() {
        return this.niveisPerdidos;
    }
}
