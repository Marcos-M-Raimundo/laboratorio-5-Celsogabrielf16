public class Item {
    private String nome;
    private int bonusPoder;
    private int valor;
    private String tipo;
    
    // Construtor que recebe todas as propriedades
    public Item(String nome, int bonusPoder, int valor, String tipo) {
        this.nome = nome;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;
    }
}
