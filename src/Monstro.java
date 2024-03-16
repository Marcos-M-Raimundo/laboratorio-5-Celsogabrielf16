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
