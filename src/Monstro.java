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

    // Getters e setters para cada atributo do monstro
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPoder() {
        return this.poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getQuantidadeDeTesouros() {
        return this.quantidadeDeTesouros;
    }

    public void setQuantidadeDeTesouros(int quantidadeDeTesouros) {
        this.quantidadeDeTesouros = quantidadeDeTesouros;
    }

    public int getNiveisPerdidos() {
        return this.niveisPerdidos;
    }

    public void setNiveisPerdidos(int niveisPerdidos) {
        this.niveisPerdidos = niveisPerdidos;
    }
}
