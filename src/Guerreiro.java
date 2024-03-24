public class Guerreiro extends Classe {
    private Item itemCabeca;
    private Item itemCorpo;
    
    public Guerreiro(String descricao) {
        super(descricao);
    }

    public Guerreiro(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCabeca, Item itemCorpo) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
    }

    public Item getItemCabeca() {
        return this.itemCabeca;
    }

    public Item getItemCorpo() {
        return this.itemCorpo;
    }
}
