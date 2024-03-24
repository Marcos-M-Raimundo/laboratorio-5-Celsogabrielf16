public class Ladrao extends Classe {
    private Item itemCorpo;

    public Ladrao(String descricao) {
        super(descricao);
    }

    public Ladrao(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCorpo) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCorpo = itemCorpo;
    }

    // Método padrao chamado quando imprimimos a classe Ladrao
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ladrao { ")
            .append("Descrição: ").append(this.getDescricao())
            .append(", Item da mão direita: ").append(this.getItemMaoDireita())
            .append(", Item da mão esquerda: ").append(this.getItemMaoEsquerda())
            .append(", Item do pé: ").append(this.getItemPe())
            .append(", Item do corpo: ").append(this.itemCorpo)
            .append(" }");
        return stringBuilder.toString();
    }

    public Item getItemCorpo() {
        return this.itemCorpo;
    }

    public void setItemCorpo (Item itemCorpo) {
        this.itemCorpo = itemCorpo;
    }
}
