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

    // Retorna uma String com todos os atributos do monstro
    public String toString() {
        return "Classe: Monstro, propridades do monstro " + nome + ": " + poder + " " + quantidadeDeTesouros + " " + niveisPerdidos + "\n";
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
