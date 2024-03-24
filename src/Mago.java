public class Mago extends Classe {
    Item itemCabeca;

    public Mago(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCabeca) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCabeca = itemCabeca;
    }

    public Item getItemCabeca() {
        return this.itemCabeca;
    }
}
