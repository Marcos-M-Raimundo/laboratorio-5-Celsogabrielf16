package app;

public class Monstro {
    private final String nome;
    private int poder;
    private int tesouros;
    private int niveisPerdidos;

    // Construtor que recebe todos os atributos do monstro
    public Monstro(String nome, int poder, int tesouros, int niveisPerdidos) {
        this.nome = nome;
        this.setPoder(poder);
        this.setTesouros(tesouros);
        this.setNiveisPerdidos(niveisPerdidos);
    }

    // Método padrao chamado quando imprimimos a classe Monstro
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Monstro { ")
            .append("Nome: ").append(this.getNome())
            .append(", Poder: ").append(this.getPoder())
            .append(", Número de Tesouros: ").append(this.getTesouros())
            .append(", Níveis Perdidos: ").append(this.getNiveisPerdidos())
            .append(" }");

        return stringBuilder.toString();
    }

    // Getters e setters para cada atributo do monstro
    public String getNome() {
        return this.nome;
    }

    public int getPoder() {
        return this.poder;
    }

    private void setPoder(int poder) {
        this.poder = poder;
    }

    public int getTesouros() {
        return this.tesouros;
    }

    private void setTesouros(int tesouros) {
        this.tesouros = tesouros;
    }

    public int getNiveisPerdidos() {
        return this.niveisPerdidos;
    }

    private void  setNiveisPerdidos(int niveisPerdidos) {
        this.niveisPerdidos = niveisPerdidos;
    }
}
