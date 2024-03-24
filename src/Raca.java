public class Raca {
    private final String descricao;
    private String nomeDaRaca;
    private final int minimoPraFugir;

    public Raca(String nomeDaRaca, String descricao, int minimoPraFugir) {
        this.descricao = descricao;
        this.nomeDaRaca = nomeDaRaca;
        this.minimoPraFugir = minimoPraFugir;
    }

    // Método padrao chamado quando imprimimos a classe Raca
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Raca { ")
            .append("Nome : ").append(this.nomeDaRaca)
            .append(", Descrição: ").append(this.descricao)
            .append(", Minimo para Fugir: ").append(this.minimoPraFugir)
            .append(" }");
        return stringBuilder.toString();
    }

    // Getters e setters para cada atributo da raca
    public String getDescricao() {
        return this.descricao;
    }

    public String getNomeDaRaca() {
        return this.nomeDaRaca;
    }

    public void setNomeDaRaca(String nomeDaRaca) {
        this.nomeDaRaca = nomeDaRaca;
    }

    public int getMinimoPraFugir() {
        return this.minimoPraFugir;
    }
}
