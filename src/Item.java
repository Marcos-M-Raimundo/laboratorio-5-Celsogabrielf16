public class Item {
    private String nome;
    private int bonusPoder;
    private int valor;
    private String tipo;
    
    public Item(String nome, int bonusPoder, int valor, String tipo) {
        this.nome = nome;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public int getBonusPoder() {
        return this.bonusPoder;
    }

    public int getValor() {
        return this.valor;
    }
        
    public String getTipo() {
        return this.tipo;
    }
}
