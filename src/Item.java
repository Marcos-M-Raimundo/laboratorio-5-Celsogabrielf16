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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBonusPoder() {
        return this.bonusPoder;
    }

    public void setBonusPoder(int bonusPoder) {
        this.bonusPoder = bonusPoder;
    }

    public int getValor() {
        return this.valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
        
    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
