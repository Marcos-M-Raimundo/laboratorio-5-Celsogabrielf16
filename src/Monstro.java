public class Monstro {
    private String nome;
    private int poder;
    private int quantidadeDeTesouros;
    private int niveisPerdidos;

    public Monstro(String nome, int poder, int quantidadeDeTesouros, int niveisPerdidos) {
        this.nome = nome;
        this.poder = poder;
        this.quantidadeDeTesouros = quantidadeDeTesouros;
        this.niveisPerdidos = niveisPerdidos;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPoder() {
        return this.poder;
    }

    public int getQuantidadeDeTesouros() {
        return this.quantidadeDeTesouros;
    }

    public int getNiveisPerdidos() {
        return this.niveisPerdidos;
    }
}
