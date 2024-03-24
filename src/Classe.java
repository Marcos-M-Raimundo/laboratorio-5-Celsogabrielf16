public class Classe {
    private final String descricao;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    public Classe(String descricao) {
        this.descricao = descricao;
    }

    public Classe(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe) {
        this.descricao = descricao;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
    }

    // Método padrao chamado quando imprimimos a classe Classe
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Classe { ")
            .append("Descricao: ").append(this.descricao)
            .append(", Item da mão direita: ").append(this.itemMaoDireita)
            .append(", Item da mão esquerda: ").append(this.itemMaoEsquerda)
            .append(", Item do pe: ").append(this.itemPe)
            .append(" }");
        return stringBuilder.toString();
    }

    // Verifica se alguma das mãos do jogador está vazia
    public boolean possuiMaoVazia() {
        if ((this.itemMaoDireita == null) || (this.itemMaoEsquerda == null)) {
            return true;
        }
        return false;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Item getItemMaoDireita() {
        return this.itemMaoDireita;
    }

    public void setItemMaoDireita (Item itemMaoDireita) {
        this.itemMaoDireita = itemMaoDireita;
    }

    public Item getItemMaoEsquerda() {
        return this.itemMaoEsquerda;
    }

    public void setItemMaoEsquerda (Item itemMaoEsquerda) {
        this.itemMaoEsquerda = itemMaoEsquerda;
    }

    public Item getItemPe() {
        return this.itemPe;
    }

    public void setItemPe (Item itemPe) {
        this.itemPe = itemPe;
    }
}
