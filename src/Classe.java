public class Classe {
    private final String descricao;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    public Classe(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe) {
        this.descricao = descricao;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
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
