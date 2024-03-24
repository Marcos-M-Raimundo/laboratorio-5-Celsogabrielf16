public class Mago extends Classe {
    Item itemCabeca;

    public Mago(String descricao) {
        super(descricao);
    }

    public Mago(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCabeca) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCabeca = itemCabeca;
    }

    // Método padrao chamado quando imprimimos a classe Mago
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mago { ")
            .append("Descrição: ").append(this.getDescricao())
            .append(", Item da mão direita: ").append(this.getItemMaoDireita())
            .append(", Item da mão esquerda: ").append(this.getItemMaoEsquerda())
            .append(", Item do pé: ").append(this.getItemPe())
            .append(", Item da cabeça: ").append(this.itemCabeca)
            .append(" }");
        return stringBuilder.toString();
    }

    public Item getItemCabeca() {
        return this.itemCabeca;
    }

    public void setItemCabeca (Item itemCabeca) {
        this.itemCabeca = itemCabeca;
    }
}
