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
}
