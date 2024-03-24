import java.util.List;

public class Item {
    private final String nome;
    private int bonusPoder;
    private int valor;
    private String tipo;
    private boolean itemGrande;
    private List<Classe> classesCompativeis;

    // Construtor que recebe todos os atributos do item
    public Item(String nome, int bonusPoder, int valor, String tipo, boolean itemGrande, List<Classe> classesCompativeis) {
        this.nome = nome;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;
        this.itemGrande = itemGrande;
        this.classesCompativeis = classesCompativeis;
    }

    // Retorna uma String com todos os atributos do item
    public String toString() {
        return "Classe: Item, propridades do item " + nome + ": " + bonusPoder + " " + valor + " " + tipo;
    }

    // Getters e setters para cada atributo do item
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
