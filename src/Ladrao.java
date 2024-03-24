public class Ladrao extends Classe {
    private Item itemCorpo;

    public Ladrao(String descricao) {
        super(descricao);
    }

    public Ladrao(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCorpo) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCorpo = itemCorpo;
    }

    public Item getItemCorpo() {
        return this.itemCorpo;
    }
}
