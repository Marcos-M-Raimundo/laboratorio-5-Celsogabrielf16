public class Raca {
    private final String descricao;
    private String nomeDaRaca;
    private final int minimoPraFugir;

    public Raca(String descricao, String nomeDaRaca, int minimoPraFugir) {
        this.descricao = descricao;
        this.nomeDaRaca = nomeDaRaca;
        this.minimoPraFugir = minimoPraFugir;
    }

    // Retorna uma String com todos os atributos do item
    public String toString() {
        return "Classe: Raca, propridades da raça " + nomeDaRaca + ": " + descricao + " " + minimoPraFugir + "\n";
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
