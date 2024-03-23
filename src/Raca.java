public class Raca {
    private final String descricao;
    private String nomeDaRaca;
    private final int minimoPraFugir;

    public Raca(String descricao, String nomeDaRaca, int minimoPraFugir) {
        this.descricao = descricao;
        this.nomeDaRaca = nomeDaRaca;
        this.minimoPraFugir = minimoPraFugir;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getNomeDaRaca() {
        return this.nomeDaRaca;
    }

    public int getMinimoPraFugir() {
        return this.minimoPraFugir;
    }
}
